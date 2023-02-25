package com.techeer.q1hackathon.common.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @set:CreatedDate
    var createdAt: LocalDateTime? = LocalDateTime.now()

    @set:LastModifiedDate
    var updatedAt: LocalDateTime? = LocalDateTime.now()

}
