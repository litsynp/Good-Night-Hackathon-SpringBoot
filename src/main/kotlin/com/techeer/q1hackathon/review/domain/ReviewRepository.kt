package com.techeer.q1hackathon.review.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface ReviewRepository : JpaRepository<Review, Long> {

    fun findOneById(@Param(value = "id") id: Long): Review?

}
