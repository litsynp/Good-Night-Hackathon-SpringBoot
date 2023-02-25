package com.techeer.q1hackathon.restaurant.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Restaurant(
    var name: String,

    var category: String,

    private var deletedAt: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    fun update(name: String, category: String) {
        this.name = name
        this.category = category
    }

    fun deleteAt(deletedAt: LocalDateTime) {
        this.deletedAt = deletedAt
    }

}
