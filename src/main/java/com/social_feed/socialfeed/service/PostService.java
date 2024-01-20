package com.social_feed.socialfeed.service;

import com.social_feed.socialfeed.dto.request.PostRequest;
import com.social_feed.socialfeed.dto.response.PostResponse;

public interface PostService {
  PostResponse create(PostRequest dto);
}