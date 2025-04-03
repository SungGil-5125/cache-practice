package com.sunggil0125.cache.services

import com.sunggil0125.cache.controllers.CreatePostRequest
import com.sunggil0125.cache.domains.Post
import com.sunggil0125.cache.domains.PostRepository
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import kotlin.test.Test

@SpringBootTest
class PostCommandServiceUnitTest {
    @Autowired
    private lateinit var sut: PostCommandService

    @MockitoBean
    private lateinit var postRepository: PostRepository

    @Test
    fun `게시글이 정상적으로 생성 되어야 한다`() {
        // given
        val request = CreatePostRequest(
            title = "title",
            content = "content",
        )
        `when`(postRepository.save(any(Post::class.java))).thenReturn(any(Post::class.java))

        // when
        sut.createPost(request)

        // then
        verify(postRepository).save(any(Post::class.java))
    }
}