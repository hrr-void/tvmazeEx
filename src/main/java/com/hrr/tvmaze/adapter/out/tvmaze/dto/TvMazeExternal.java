package com.hrr.tvmaze.adapter.out.tvmaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TvMazeExternal(
    Long tvrage,
    @JsonProperty("thetvdb") Long theTvDb,
    @JsonProperty("imdb") String imbd
){
}
