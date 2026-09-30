package com.hrr.tvmaze.adapter.out.tvmaze.dto;

import java.time.LocalDateTime;

public record TvMazeCountry(
        String name,
        String code,
        String timezone
) {
}
