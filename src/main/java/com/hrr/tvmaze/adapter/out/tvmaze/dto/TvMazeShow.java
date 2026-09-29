package com.hrr.tvmaze.adapter.out.tvmaze.dto;

import java.util.List;

public record TvMazeShow(
        Long id,
        String name,
        List<String> genres,
        TvMazeNetwork network,
        TvMazeChannel channel,
        String summary
) {
}
