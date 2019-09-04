package com.junjie.secdraweb.core.interceptor

import com.junjie.secdraaccount.core.component.AccountConfig
import com.junjie.secdraaccount.service.AccountService
import com.junjie.secdracore.annotations.Auth
import com.junjie.secdracore.exception.SignInException
import com.junjie.secdracore.util.CookieUtil
import com.junjie.secdracore.util.DateUtil
import com.junjie.secdracore.util.JwtUtil
import com.junjie.secdraservice.service.UserService
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.lang.Nullable
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author fjj
 * 登录验证拦截器
 */
class AuthInterceptor(private val accountConfig: AccountConfig,
                      private val redisTemplate: StringRedisTemplate,
                      private val accountService: AccountService,
                      private val userService: UserService) : HandlerInterceptor {
    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler is HandlerMethod) {
            val hm = handler as HandlerMethod?
            //程序运行的bean
            hm!!.beanType
            //运行的方法
            val m = hm.method

            try {
                val cookieMap = CookieUtil.readCookieMap(request)
                val tokenCookie = cookieMap["token"]
                val token = if (tokenCookie != null) {
                    tokenCookie.value
                } else {
                    request.getHeader("token")
                }
                val claims = JwtUtil.parseJWT(token, accountConfig.jwtSecretString)
                val accountId = claims["accountId"] as String
                //过期时间
                val exp = Date(claims["exp"]!!.toString().toLong() * 1000)
                //生成时间
                val nbf = Date(claims["nbf"]!!.toString().toLong() * 1000)
                //最后更改密码时间
                val rePasswordDateStr = redisTemplate.opsForValue()[String.format(accountConfig.updatePasswordTimePrefix, accountId)]
                val rePasswordDate: Date?
                //缓存穿透
                rePasswordDate = if (rePasswordDateStr.isNullOrEmpty()) {
                    val info = accountService.get(accountId)
                    //最后更改密码时间写入redis
                    redisTemplate.opsForValue().set(
                            String.format(accountConfig.updatePasswordTimePrefix, accountId),
                            info.rePasswordDate.time.toString())
                    info.rePasswordDate
                } else {
                    Date(rePasswordDateStr!!.toLong())
                }
                if (DateUtil.getDistanceTimestamp(Date(), exp) < 0) {
                    throw SignInException("用户登录已过期")
                }
                if (accountId.isEmpty()) {
                    throw SignInException("请重新登录")
                }
                if (DateUtil.getDistanceTimestamp(rePasswordDate, nbf) < 0) {
                    redisTemplate.opsForValue().set(String.format(accountConfig.updatePasswordTimePrefix, accountId), "")
                    throw SignInException("请重新登录")
                }
                request.setAttribute("userId", userService.getByAccountId(accountId).id!!)
            } catch (e: Exception) {
                if (m.isAnnotationPresent(Auth::class.java)) {
                    throw  e as? SignInException ?: SignInException("请重新登录")
                }
            }
        }
        return true
    }

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, @Nullable modelAndView: ModelAndView?) {
    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, @Nullable ex: java.lang.Exception?) {
    }
}
