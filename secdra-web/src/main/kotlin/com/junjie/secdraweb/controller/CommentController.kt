package com.junjie.secdraweb.controller

import com.junjie.secdracore.annotations.Auth
import com.junjie.secdracore.annotations.CurrentUserId
import com.junjie.secdracore.annotations.RestfulPack
import com.junjie.secdraservice.model.Comment
import com.junjie.secdraservice.model.CommentMessage
import com.junjie.secdraservice.model.User
import com.junjie.secdraservice.service.CommentMessageService
import com.junjie.secdraservice.service.CommentService
import com.junjie.secdraservice.service.UserService
import com.junjie.secdraweb.service.WebSocketService
import com.junjie.secdraweb.vo.CommentVO
import com.junjie.secdraweb.vo.UserVO
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author fjj
 * 评论的控制器
 */
@RestController
@RequestMapping("comment")
class CommentController(private val commentService: CommentService,
                        private val userService: UserService,
                        private val commentMessageService: CommentMessageService,
                        private val webSocketService: WebSocketService) {

    /**
     * 发表评论
     */
    @Auth
    @PostMapping("/save")
    @RestfulPack
    fun save(@CurrentUserId criticId: String, authorId: String, drawId: String, content: String): CommentVO {
        content.isEmpty() && throw Exception("评论不能为空")
        (authorId.isEmpty() || drawId.isEmpty()) && throw Exception("不能为空")
        val comment = Comment(authorId, criticId, drawId, content)
        val vo = getVO(commentService.save(comment))
        val commentMessage = CommentMessage(vo.id, vo.authorId, vo.drawId, vo.criticId, vo.content)
        commentMessageService.save(commentMessage)
        webSocketService.sendComment(criticId, authorId)
        return vo
    }

    /**
     * 获取4条
     */
    @GetMapping("listTop4")
    @RestfulPack
    fun listTop4(drawId: String): List<CommentVO> {
        return getListVO(commentService.listTop4(drawId))
    }

    /**
     * 获取列表
     */
    @GetMapping("list")
    @RestfulPack
    fun list(drawId: String): List<CommentVO> {
        return getListVO(commentService.list(drawId))
    }

    /**
     * 分页获取
     */
    @GetMapping("pagingByDrawId")
    @RestfulPack
    fun pagingByDrawId(drawId: String, @PageableDefault(value = 20) pageable: Pageable): Page<CommentVO> {
        return getPageVO(commentService.paging(drawId, pageable))
    }

    private fun getVO(comment: Comment): CommentVO {
        val commentVO = CommentVO(comment)
        commentVO.author = UserVO(userService.getInfo(comment.authorId))
        commentVO.critic = UserVO(userService.getInfo(comment.criticId))
        return commentVO
    }

    private fun getPageVO(page: Page<Comment>): Page<CommentVO> {
        val commentVOList = page.content.map { getVO(it) }
        return PageImpl(commentVOList, page.pageable, page.totalElements)
    }

    private fun getListVO(list: List<Comment>): List<CommentVO> {
        return list.map { getVO(it) }
    }
}