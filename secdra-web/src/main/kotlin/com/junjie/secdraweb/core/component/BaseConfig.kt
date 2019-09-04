package com.junjie.secdraweb.core.component

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author fjj
 * 配置
 */
@Component
@ConfigurationProperties("base")
class BaseConfig {
    lateinit var notUUID: String

    lateinit var qiniuAccessKey: String

    lateinit var qiniuSecretKey: String
    //临时储存空间
    lateinit var qiniuTempBucket: String
    //头像储存空间
    lateinit var qiniuHeadBucket: String
    //背景储存空间
    lateinit var qiniuBackBucket: String
    //主储存空间
    lateinit var qiniuBucket: String
    //临时储存空间
    lateinit var qiniuTempBucketUrl: String
    //头像储存空间
    lateinit var qiniuHeadBucketUrl: String
    //背景储存空间
    lateinit var qiniuBackBucketUrl: String
    //主储存空间
    lateinit var qiniuBucketUrl: String
}
