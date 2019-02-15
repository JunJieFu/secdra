package com.junjie.secdraservice.service

import com.junjie.secdraservice.model.Comment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


/**
 * 评论的服务
 *
 * @author fjj
 */
interface ICommentService {
    fun save(comment: Comment): Comment

    fun listUnread(authorId: String): List<Comment>

    fun countUnread(authorId: String): Long

    fun pagingByDrawId(drawId: String, pageable: Pageable): Page<Comment>
}