package com.social_feed.socialfeed.service.implementation;

import org.springframework.stereotype.Service;

import com.social_feed.socialfeed.dto.request.PostRequest;
import com.social_feed.socialfeed.dto.response.PostResponse;
import com.social_feed.socialfeed.entity.Post;
import com.social_feed.socialfeed.repository.PostRepository;
import com.social_feed.socialfeed.service.PostService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
  private final PostRepository postRepository;

  @Override
  public PostResponse create(PostRequest dto) {
    Post post = toEntity(dto);
    post = postRepository.save(post);
    return toResponse(post);
  }

  private Post toEntity(PostRequest dto) {
    Post post = new Post();
    post.setContent(dto.content());
    return post;
  }

  private PostResponse toResponse(Post post) {
    return new PostResponse(post.getId(), post.getContent(), post.getCreatedAt());
  }
}
