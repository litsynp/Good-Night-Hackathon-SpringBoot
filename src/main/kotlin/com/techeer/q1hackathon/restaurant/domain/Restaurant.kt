package com.techeer.q1hackathon.restaurant.domain

import com.techeer.q1hackathon.common.domain.BaseEntity
import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
class Restaurant(
    var name: String,

    var category: String,

    private var deletedAt: LocalDateTime? = null,
) : BaseEntity() {

    fun update(name: String, category: String) {
        this.name = name
        this.category = category
    }

    fun deleteAt(deletedAt: LocalDateTime) {
        this.deletedAt = deletedAt
    }

}
