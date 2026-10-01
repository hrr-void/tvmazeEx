package com.hrr.tvmaze.domain.model;

public record WebChannel(
        String id,
        String name,
        Country country,
        String officialSite
) {
}
