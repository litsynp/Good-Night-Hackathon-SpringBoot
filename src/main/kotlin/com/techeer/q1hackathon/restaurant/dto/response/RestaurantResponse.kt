package com.techeer.q1hackathon.restaurant.dto.response

import com.techeer.q1hackathon.restaurant.domain.Restaurant

data class RestaurantResponse(
    val id: Long,
    val name: String,
    val category: String,
) {

    companion object {
        fun of(restaurant: Restaurant): RestaurantResponse {
            return RestaurantResponse(
                id = restaurant.id!!,
                name = restaurant.name,
                category = restaurant.category
            )
        }
    }

}
