package com.hrr.tvmaze.domain.model;

public record Network(
        Long id,
        String name,
        Country country,
        String officialSite
) {
}
