package com.techeer.q1hackathon.restaurant.dto.response

import com.techeer.q1hackathon.restaurant.domain.Restaurant
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(description = "Restaurant response")
data class RestaurantResponse(
    @Schema(description = "Restaurant id")
    val id: Long,

    @Schema(description = "Restaurant name")
    val name: String,

    @Schema(description = "Restaurant category")
    val category: String,

    @Schema(description = "Restaurant created at")
    val createdAt: LocalDateTime,
) {

    companion object {
        fun of(restaurant: Restaurant): RestaurantResponse {
            return RestaurantResponse(
                id = restaurant.id!!,
                name = restaurant.name,
                category = restaurant.category,
                createdAt = restaurant.createdAt!!
            )
        }
    }

}
