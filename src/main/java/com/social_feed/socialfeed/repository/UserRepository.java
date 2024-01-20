package com.social_feed.socialfeed.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social_feed.socialfeed.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Set<User> findByEmail(String email);
}
