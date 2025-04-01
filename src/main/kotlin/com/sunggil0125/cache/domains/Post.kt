package com.sunggil0125.cache.domains

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "posts")
class Post(
    @Column(name = "title", nullable = true)
    var title: String?,

    @Column(name = "content", nullable = true)
    var content: String?,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(nullable = false)
    private final val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime? = createdAt
}
