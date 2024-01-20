package com.social_feed.socialfeed.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PostRequest(@NotBlank String content) {
}
