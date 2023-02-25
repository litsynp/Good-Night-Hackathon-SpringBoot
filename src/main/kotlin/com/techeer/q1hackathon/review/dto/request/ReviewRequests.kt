package com.techeer.q1hackathon.review.dto.request

data class ReviewCreateRequest(
    val restaurantId: Long,
    val title: String,
    val content: String,
    val rating: Int,
)

data class ReviewEditRequest(
    val title: String,
    val content: String,
    val rating: Int,
)
