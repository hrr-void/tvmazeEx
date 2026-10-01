package com.hrr.tvmaze.adapter.out.tvmaze.dto;

public record TvMazeWebChannel(
        String id,
        String name,
        TvMazeCountry country,
        String officialSite
) {
}
