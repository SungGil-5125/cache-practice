package com.sunggil0125.cache.services

import com.sunggil0125.cache.controllers.CreatePostRequest
import com.sunggil0125.cache.domains.Post
import com.sunggil0125.cache.domains.PostRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostCommandService(
    private val postRepository: PostRepository,
) {
    @CacheEvict(cacheNames = ["posts"], allEntries = true)
    fun createPost(request: CreatePostRequest) {
        postRepository.save(
            Post(title = request.title, content = request.content)
        )
    }
}
