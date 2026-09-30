package com.hrr.tvmaze.adapter.out.tvmaze.dto;

import java.util.List;

public record TvMazeSchedule(
        String time,
        List<String> days
) {
}
