package com.techeer.q1hackathon.restaurant.controller

import com.techeer.q1hackathon.restaurant.dto.request.RestaurantRequest
import com.techeer.q1hackathon.restaurant.dto.response.RestaurantResponse
import com.techeer.q1hackathon.restaurant.service.RestaurantService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/restaurants")
class RestaurantController(
    private val restaurantService: RestaurantService
) {

    @PostMapping
    fun createRestaurant(@RequestBody request: RestaurantRequest): ResponseEntity<RestaurantResponse> {
        val restaurant = restaurantService.createRestaurant(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant)
    }

    @GetMapping
    fun findRestaurants(): ResponseEntity<List<RestaurantResponse>> {
        val restaurants = restaurantService.findRestaurants()
        return ResponseEntity.ok(restaurants)
    }

    @GetMapping("/{id}")
    fun findRestaurantById(@PathVariable id: Long): ResponseEntity<RestaurantResponse> {
        val restaurant = restaurantService.findRestaurantById(id)
        return ResponseEntity.ok(restaurant)
    }

    @PutMapping("/{id}")
    fun editRestaurantById(
        @PathVariable id: Long,
        @RequestBody request: RestaurantRequest
    ): ResponseEntity<RestaurantResponse> {
        val restaurant = restaurantService.editRestaurantById(id, request)
        return ResponseEntity.ok(restaurant)
    }

    @DeleteMapping("/{id}")
    fun deleteRestaurantById(@PathVariable id: Long): ResponseEntity<Unit> {
        restaurantService.deleteRestaurantById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}
