package com.social_feed.socialfeed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social_feed.socialfeed.dto.request.PostRequest;
import com.social_feed.socialfeed.dto.response.PostResponse;
import com.social_feed.socialfeed.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
  private final PostService postService;

  public ResponseEntity<PostResponse> postMethodName(@RequestBody @Valid PostRequest dto) {

    return ResponseEntity.ok(postService.create(dto));
  }

}
