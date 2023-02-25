package com.techeer.q1hackathon.restaurant.service

import com.techeer.q1hackathon.restaurant.domain.Restaurant
import com.techeer.q1hackathon.restaurant.domain.RestaurantRepository
import com.techeer.q1hackathon.restaurant.dto.request.RestaurantRequest
import com.techeer.q1hackathon.restaurant.dto.response.RestaurantResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class RestaurantService(
    private val restaurantRepository: RestaurantRepository
) {

    @Transactional(readOnly = true)
    fun findRestaurants(): List<RestaurantResponse> {
        val restaurants = restaurantRepository.findAll()
        return restaurants.map { RestaurantResponse.of(it) }
    }

    @Transactional(readOnly = true)
    fun findRestaurantById(id: Long): RestaurantResponse {
        val restaurant = restaurantRepository.findOneById(id)
            ?: throw IllegalArgumentException("Restaurant not found")
        return RestaurantResponse.of(restaurant)
    }

    @Transactional
    fun createRestaurant(request: RestaurantRequest): RestaurantResponse {
        val restaurant = restaurantRepository.save(
            Restaurant(name = request.name, category = request.category)
        )
        return RestaurantResponse.of(restaurant)
    }

    @Transactional
    fun editRestaurantById(id: Long, request: RestaurantRequest): RestaurantResponse {
        val restaurant = restaurantRepository.findOneById(id)
            ?: throw IllegalArgumentException("Restaurant not found")

        restaurant.update(name = request.name, category = request.category)
        return RestaurantResponse.of(restaurant)
    }

    @Transactional
    fun deleteRestaurantById(id: Long) {
        val restaurant = restaurantRepository.findOneById(id)
            ?: throw IllegalArgumentException("Restaurant not found")
        restaurant.deleteAt(LocalDateTime.now())
    }

}
