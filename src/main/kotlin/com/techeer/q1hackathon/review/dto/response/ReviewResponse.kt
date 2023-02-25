package com.techeer.q1hackathon.review.dto.response

import com.techeer.q1hackathon.review.domain.Review

data class ReviewResponse(
    val id: Long,
    val restaurantName: String,
    val title: String,
    val content: String,
    val rating: Int,
) {

    companion object {
        fun of(review: Review): ReviewResponse = ReviewResponse(
            id = review.id!!,
            restaurantName = review.restaurant.name,
            title = review.title,
            content = review.content,
            rating = review.rating
        )
    }

}
