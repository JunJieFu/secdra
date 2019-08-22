package com.junjie.secdraservice.dao

import com.junjie.secdraservice.model.Collection
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface CollectionDAO : JpaRepository<Collection, String> {
    fun existsByUserIdAndDrawId(userId: String, drawId: String): Boolean
    @Transactional
    fun deleteByUserIdAndDrawId(userId: String, drawId: String)

    fun countByDrawId(drawId: String): Long

    fun findAllByUserId(userId: String, pageable: Pageable): Page<Collection>
}