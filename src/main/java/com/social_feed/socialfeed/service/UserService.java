package com.social_feed.socialfeed.service;

import com.social_feed.socialfeed.dto.request.UserRequest;
import com.social_feed.socialfeed.dto.response.UserResponse;

public interface UserService {
    UserResponse create(UserRequest dto);
}
