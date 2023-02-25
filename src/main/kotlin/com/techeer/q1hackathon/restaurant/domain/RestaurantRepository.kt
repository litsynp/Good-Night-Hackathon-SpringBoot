package com.techeer.q1hackathon.restaurant.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface RestaurantRepository : JpaRepository<Restaurant, Long> {

    @Query("select r from Restaurant r where r.category = :category and r.deletedAt is null")
    fun findAllByCategory(pageable: Pageable, category: String?): Page<Restaurant>

    @Query("select r from Restaurant r where r.id = :id and r.deletedAt is null")
    fun findOneById(@Param(value = "id") id: Long): Restaurant?
}
