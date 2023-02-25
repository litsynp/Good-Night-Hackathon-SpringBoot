package com.techeer.q1hackathon.restaurant.dto.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Restaurant request")
data class RestaurantRequest(
    @Schema(description = "Restaurant name")
    val name: String,

    @Schema(description = "Restaurant category")
    val category: String,
)
