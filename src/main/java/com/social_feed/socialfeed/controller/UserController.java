package com.social_feed.socialfeed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social_feed.socialfeed.dto.request.UserRequest;
import com.social_feed.socialfeed.dto.response.UserResponse;
import com.social_feed.socialfeed.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest dto) {
        return ResponseEntity.ok(userService.create(dto));
    }
    
}
