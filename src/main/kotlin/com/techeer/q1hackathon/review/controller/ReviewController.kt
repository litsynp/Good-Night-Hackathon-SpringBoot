package com.techeer.q1hackathon.review.controller

import com.techeer.q1hackathon.review.dto.request.ReviewCreateRequest
import com.techeer.q1hackathon.review.dto.request.ReviewEditRequest
import com.techeer.q1hackathon.review.dto.response.ReviewResponse
import com.techeer.q1hackathon.review.service.ReviewService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun findReviews(
        @PageableDefault(size = 20, sort = ["createdAt"], direction = Sort.Direction.DESC)
        pageable: Pageable
    ): ResponseEntity<Page<ReviewResponse>> {
        val reviews = reviewService.findReviews(pageable)
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
