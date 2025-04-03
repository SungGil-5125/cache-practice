package com.sunggil0125.cache.controllers

import com.sunggil0125.cache.services.PostCommandService
import com.sunggil0125.cache.services.PostQueryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/posts")
class PostController(
    private val postCommandService: PostCommandService,
    private val postQueryService: PostQueryService,
) {
    @GetMapping
    fun getAllPosts(): List<PostResponse> {
        return postQueryService.fetchAllPosts()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPost(@RequestBody request: CreatePostRequest) {
        postCommandService.createPost(request)
    }
}

data class CreatePostRequest(
    val title: String,
    val content: String,
)

data class PostResponse(
    val id: Long,
    val title: String?,
    val content: String?,
) {
    constructor(): this(0, null, null)
}
