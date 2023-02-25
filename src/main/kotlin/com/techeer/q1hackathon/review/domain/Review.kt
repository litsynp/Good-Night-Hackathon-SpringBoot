package com.techeer.q1hackathon.review.domain

import com.techeer.q1hackathon.common.domain.BaseEntity
import com.techeer.q1hackathon.restaurant.domain.Restaurant
import jakarta.persistence.Entity
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne

@Entity
class Review(

    @ManyToOne
    val restaurant: Restaurant,

    var title: String,

    @Lob
    var content: String,

    var rating: Int,
) : BaseEntity() {

    fun update(title: String, content: String, rating: Int) {
        this.title = title
        this.content = content
        this.rating = rating
    }

}
