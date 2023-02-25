package com.techeer.q1hackathon.restaurant.controller

import com.techeer.q1hackathon.restaurant.dto.request.RestaurantRequest
import com.techeer.q1hackathon.restaurant.dto.response.RestaurantResponse
import com.techeer.q1hackathon.restaurant.service.RestaurantService
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
@RequestMapping("/api/v1/restaurants")
@Tag(name = "Restaurant", description = "Restaurant API")
class RestaurantController(
    private val restaurantService: RestaurantService
) {

    @PostMapping
    @Operation(summary = "Create a restaurant")
    fun createRestaurant(
        @RequestBody @Schema(description = "Restaurant create request") request: RestaurantRequest
    ): ResponseEntity<RestaurantResponse> {
        val restaurant = restaurantService.createRestaurant(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant)
    }

    @GetMapping
    @Operation(summary = "Find restaurants with pagination")
    fun findRestaurants(
        @PageableDefault(size = 20, sort = ["createdAt"], direction = Sort.Direction.DESC)
        pageable: Pageable
    ): ResponseEntity<Page<RestaurantResponse>> {
        val restaurants = restaurantService.findRestaurants(pageable)
        return ResponseEntity.ok(restaurants)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a restaurant by id")
    fun findRestaurantById(
        @PathVariable @Schema(description = "Restaurant id") id: Long
    ): ResponseEntity<RestaurantResponse> {
        val restaurant = restaurantService.findRestaurantById(id)
        return ResponseEntity.ok(restaurant)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a restaurant by id")
    fun editRestaurantById(
        @PathVariable
        @Schema(description = "Restaurant id")
        id: Long,

        @RequestBody
        @Schema(description = "Restaurant edit request")
        request: RestaurantRequest
    ): ResponseEntity<RestaurantResponse> {
        val restaurant = restaurantService.editRestaurantById(id, request)
        return ResponseEntity.ok(restaurant)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a restaurant by id")
    fun deleteRestaurantById(
        @PathVariable @Schema(description = "Restaurant id") id: Long
    ): ResponseEntity<Unit> {
        restaurantService.deleteRestaurantById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}
