package com.social_feed.socialfeed.service.implementation;

import org.springframework.stereotype.Service;

import com.social_feed.socialfeed.dto.request.UserRequest;
import com.social_feed.socialfeed.dto.response.UserResponse;
import com.social_feed.socialfeed.entity.User;
import com.social_feed.socialfeed.repository.UserRepository;
import com.social_feed.socialfeed.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest dto) {
        User user = toEntity(dto);
        user = userRepository.save(user);
        return toResponse(user);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    private User toEntity(UserRequest dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setName(dto.name());
        return user;
    }
}
