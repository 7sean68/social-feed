package com.social_feed.socialfeed.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social_feed.socialfeed.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  Set<Post> findByContent(String content);
}