package com.junjie.secdraservice.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * 足迹
 * @author fjj
 */
@Entity
class Footprint {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    var id: String? = null

    var userId: String? = null

    var drawId: String? = null

    @CreatedDate
    var createDate: Date? = null

    @LastModifiedDate
    var modifiedDate: Date? = null
}