package com.hrr.tvmaze.domain.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Comment(
        Long showId,
        @NotBlank
        String comment,
        @NotNull
        @Min(0)
        @Max(5)
        Integer rating
) {
}
