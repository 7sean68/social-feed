package com.social_feed.socialfeed.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Valid
public record UserRequest(@NotBlank String name, @Email @NotBlank String email) {
}
