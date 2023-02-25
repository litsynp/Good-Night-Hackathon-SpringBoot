package com.techeer.q1hackathon.review.dto.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Review create request")
data class ReviewCreateRequest(
    @Schema(description = "Restaurant id")
    val restaurantId: Long,

    @Schema(description = "Review title")
    val title: String,

    @Schema(description = "Review content")
    val content: String,

    @Schema(description = "Review rating")
    val rating: Int,
)

@Schema(description = "Review edit request")
data class ReviewEditRequest(
    @Schema(description = "Review id")
    val title: String,

    @Schema(description = "Review content")
    val content: String,

    @Schema(description = "Review rating")
    val rating: Int,
)
