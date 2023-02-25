package com.techeer.q1hackathon.review.controller

import com.techeer.q1hackathon.review.dto.request.ReviewCreateRequest
import com.techeer.q1hackathon.review.dto.request.ReviewEditRequest
import com.techeer.q1hackathon.review.dto.response.ReviewResponse
import com.techeer.q1hackathon.review.service.ReviewService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/reviews")
@Tag(name = "Review", description = "Review API")
class ReviewController(
    private val reviewService: ReviewService
) {

    @PostMapping
    @Operation(summary = "Create a review")
    fun createReview(
        @RequestBody
        @Schema(description = "Review create request")
        request: ReviewCreateRequest
    ): ResponseEntity<ReviewResponse> {
        val review = reviewService.createReview(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(review)
    }

    @GetMapping
    @Operation(summary = "Find reviews with pagination")
    fun findReviews(
        @PageableDefault(size = 20, sort = ["createdAt"], direction = Sort.Direction.DESC)
        pageable: Pageable,

        @RequestParam(value = "title", required = false)
        @Schema(description = "Filter by title")
        title: String?,

        @RequestParam(value = "content", required = false)
        @Schema(description = "Filter by content")
        content: String?,
    ): ResponseEntity<Page<ReviewResponse>> {
        val reviews = reviewService.findReviews(pageable, title, content)
        return ResponseEntity.ok(reviews)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a review by id")
    fun findReviewById(
        @PathVariable @Schema(description = "Review id") id: Long
    ): ResponseEntity<ReviewResponse> {
        val review = reviewService.findReviewById(id)
        return ResponseEntity.ok(review)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a review by id")
    fun editReviewById(
        @PathVariable @Schema(description = "Review id") id: Long,
        @RequestBody @Schema(description = "Review edit request") request: ReviewEditRequest
    ): ResponseEntity<ReviewResponse> {
        val review = reviewService.editReviewById(id, request)
        return ResponseEntity.ok(review)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a review by id")
    fun deleteReviewById(
        @PathVariable @Schema(description = "Review id") id: Long
    ): ResponseEntity<Unit> {
        reviewService.deleteReviewById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}
