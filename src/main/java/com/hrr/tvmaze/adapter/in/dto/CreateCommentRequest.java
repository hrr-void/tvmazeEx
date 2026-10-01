package com.hrr.tvmaze.adapter.in.dto;

import jakarta.validation.constraints.*;

public record CreateCommentRequest(
        @NotNull
        @Positive
        Long showId,
        @NotBlank
        String comment,
        @NotNull
        @Min(0)
        @Max(5)
        Integer rating
) {
}
