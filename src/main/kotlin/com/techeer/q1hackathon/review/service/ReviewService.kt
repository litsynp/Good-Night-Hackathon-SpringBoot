package com.techeer.q1hackathon.review.service

import com.techeer.q1hackathon.restaurant.domain.RestaurantRepository
import com.techeer.q1hackathon.review.domain.Review
import com.techeer.q1hackathon.review.domain.ReviewRepository
import com.techeer.q1hackathon.review.dto.request.ReviewCreateRequest
import com.techeer.q1hackathon.review.dto.request.ReviewEditRequest
import com.techeer.q1hackathon.review.dto.response.ReviewResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val restaurantRepository: RestaurantRepository
) {

    @Transactional(readOnly = true)
    fun findReviews(pageable: Pageable): Page<ReviewResponse> {
        val reviews = reviewRepository.findAll(pageable)
        return reviews.map { ReviewResponse.of(it) }
    }

    @Transactional(readOnly = true)
    fun findReviewById(id: Long): ReviewResponse {
        val review = reviewRepository.findOneById(id)
            ?: throw IllegalArgumentException("Review not found")
        return ReviewResponse.of(review)
    }

    @Transactional
    fun createReview(request: ReviewCreateRequest): ReviewResponse {
        val restaurant = restaurantRepository.findOneById(request.restaurantId)
            ?: throw IllegalArgumentException("Restaurant not found")

        val review = reviewRepository.save(
            Review(
                restaurant = restaurant,
                title = request.title,
                content = request.content,
                rating = request.rating,
            )
        )

        return ReviewResponse.of(review)
    }

    @Transactional
    fun editReviewById(id: Long, request: ReviewEditRequest): ReviewResponse {
        val review = reviewRepository.findOneById(id)
            ?: throw IllegalArgumentException("Review not found")
        review.update(title = request.title, content = request.content, rating = request.rating)
        return ReviewResponse.of(review)
    }

    @Transactional
    fun deleteReviewById(id: Long) {
        val review = reviewRepository.findOneById(id)
            ?: throw IllegalArgumentException("Review not found")
        reviewRepository.delete(review)
    }

}
