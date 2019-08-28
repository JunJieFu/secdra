package com.junjie.secdraservice.serviceimpl

import com.junjie.secdradata.database.primary.dao.ReplyDAO
import com.junjie.secdradata.database.primary.entity.Reply
import com.junjie.secdraservice.service.ReplyService
import org.springframework.stereotype.Service

@Service
class ReplyServiceImpl(private val replyDAO: ReplyDAO) : ReplyService {
    override fun save(reply: Reply): Reply {
        return replyDAO.save(reply)
    }

    override fun list(commentId: String): List<Reply> {
        return replyDAO.findAllByCommentIdOrderByCreateDateDesc(commentId)
    }
}