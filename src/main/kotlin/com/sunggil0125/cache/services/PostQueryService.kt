package com.sunggil0125.cache.services

import com.sunggil0125.cache.controllers.PostResponse
import com.sunggil0125.cache.domains.PostRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostQueryService(
    private val postRepository: PostRepository,
) {
    @Cacheable(cacheNames = ["posts"])
    fun fetchAllPosts(): List<PostResponse> {
        return postRepository.findAll().map { post ->
            PostResponse(
                id = post.id,
                title = post.title,
                content = post.content,
            )
        }
    }
}