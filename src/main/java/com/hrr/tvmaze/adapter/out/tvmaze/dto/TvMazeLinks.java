package com.hrr.tvmaze.adapter.out.tvmaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TvMazeLinks(
        TvmazeSelf self,
        @JsonProperty("previousepisode") TvMazePreviousEpisode prevEpisode
) {
}
