package com.social_feed.socialfeed.dto.response;

import java.time.ZonedDateTime;

public record PostResponse(Long id, String content, ZonedDateTime createdAt) {
}
