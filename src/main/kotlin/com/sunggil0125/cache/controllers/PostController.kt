package com.sunggil0125.cache.controllers

import com.sunggil0125.cache.services.PostQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/posts")
class PostController(
    private val postQueryService: PostQueryService,
) {
    @GetMapping
    fun getAllPosts(): List<PostResponse> {
        return postQueryService.fetchAllPosts()
    }
}

data class PostResponse(
    val id: Long,
    val title: String?,
    val content: String?,
)
