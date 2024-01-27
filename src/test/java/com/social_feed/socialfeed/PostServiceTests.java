package com.social_feed.socialfeed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.social_feed.socialfeed.dto.request.PostRequest;
import com.social_feed.socialfeed.dto.response.PostResponse;
import com.social_feed.socialfeed.entity.Post;
import com.social_feed.socialfeed.repository.PostRepository;
import com.social_feed.socialfeed.service.PostService;
import com.social_feed.socialfeed.service.implementation.PostServiceImpl;


@ExtendWith(MockitoExtension.class)
class PostServiceTests {
    private static final String SOME_CONTENT = "Some Content";

    @Mock
    private PostRepository postRepository;

    private PostService postService;

    @Captor
    private ArgumentCaptor<Post> postCaptor;

    @BeforeEach
    void setup() {
        postService = new PostServiceImpl(postRepository);
    }

    @Test
    void whenDtoIsNullExpectException() {
        assertThrows(NullPointerException.class, () -> postService.create(null));
    }

    @Test
    void createResponseConsistent() {
        when(postRepository.save(postCaptor.capture())).thenAnswer(call -> call.getArgument(0, Post.class));

        PostRequest request = new PostRequest(SOME_CONTENT);

        PostResponse response = postService.create(request);

        assertEquals(SOME_CONTENT, response.content());

        assertEquals(SOME_CONTENT, postCaptor.getValue().getContent());
    }
}
