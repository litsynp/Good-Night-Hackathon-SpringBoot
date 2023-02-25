package com.techeer.q1hackathon.review.domain

import com.techeer.q1hackathon.restaurant.domain.Restaurant
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    fun update(title: String, content: String, rating: Int) {
        this.title = title
        this.content = content
        this.rating = rating
    }

}
