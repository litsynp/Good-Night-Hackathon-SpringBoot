package com.techeer.q1hackathon.review.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface ReviewRepository : JpaRepository<Review, Long> {

    fun findAllByTitleContainingOrContentContaining(
        pageable: Pageable,
        @Param(value = "title") title: String?,
        @Param(value = "content") content: String?
    ): Page<Review>

    fun findOneById(@Param(value = "id") id: Long): Review?

}
