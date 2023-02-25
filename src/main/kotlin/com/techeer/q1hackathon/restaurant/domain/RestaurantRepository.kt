package com.techeer.q1hackathon.restaurant.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface RestaurantRepository : JpaRepository<Restaurant, Long> {

    @Query("select r from Restaurant r where r.deletedAt is null")
    override fun findAll(): List<Restaurant>

    @Query("select r from Restaurant r where r.id = :id and r.deletedAt is null")
    fun findOneById(@Param(value = "id") id: Long): Restaurant?
}
