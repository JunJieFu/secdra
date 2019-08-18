package com.junjie.secdraservice.dao

import com.junjie.secdraservice.model.SystemMessage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface SystemMessageDAO : JpaRepository<SystemMessage, String>, JpaSpecificationExecutor<SystemMessage> {
    fun findAllByUserIdOrderByCreateDateDesc(userId: String): List<SystemMessage>

    fun countByUserIdAndIsRead(userId: String, isRead: Boolean): Long

    fun findAllByUserIdAndIsReadOrderByCreateDateDesc(userId: String, isRead: Boolean): List<SystemMessage>
}