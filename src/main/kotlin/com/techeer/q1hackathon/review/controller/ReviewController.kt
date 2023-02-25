package com.techeer.q1hackathon.review.controller

import com.techeer.q1hackathon.review.dto.request.ReviewCreateRequest
import com.techeer.q1hackathon.review.dto.request.ReviewEditRequest
import com.techeer.q1hackathon.review.dto.response.ReviewResponse
import com.techeer.q1hackathon.review.service.ReviewService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/reviews")
class ReviewController(
    private val reviewService: ReviewService
) {

    @PostMapping
    fun createReview(@RequestBody request: ReviewCreateRequest): ResponseEntity<ReviewResponse> {
        val review = reviewService.createReview(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(review)
    }

    @GetMapping
    fun findReviews(): ResponseEntity<List<ReviewResponse>> {
        val reviews = reviewService.findReviews()
        return ResponseEntity.ok(reviews)
    }

    @GetMapping("/{id}")
    fun findReviewById(@PathVariable id: Long): ResponseEntity<ReviewResponse> {
        val review = reviewService.findReviewById(id)
        return ResponseEntity.ok(review)
    }

    @PutMapping("/{id}")
    fun editReviewById(
        @PathVariable id: Long,
        @RequestBody request: ReviewEditRequest
    ): ResponseEntity<ReviewResponse> {
        val review = reviewService.editReviewById(id, request)
        return ResponseEntity.ok(review)
    }

    @DeleteMapping("/{id}")
    fun deleteReviewById(@PathVariable id: Long): ResponseEntity<Unit> {
        reviewService.deleteReviewById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}
