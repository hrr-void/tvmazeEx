package com.hrr.tvmaze.domain.model;

public record Comment(
        Long showId,
        String comment,
        Integer rating
) {
}