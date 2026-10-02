package com.hrr.tvmaze.adapter.out.tvmaze.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TvMazeShowDetails(
        Double score,
        Long id,
        String url,
        String name,
        String type,
        String language,
        List<String> genres,
        String status,
        Integer runtime,
        Integer averageRuntime,
        String premiered,
        String ended,
        String officialSite,
        TvMazeSchedule schedule,
        TvMazeRating rating,
        Double weight,
        TvMazeNetwork network,
        TvMazeWebChannel webChannel,
        //dvdContri siempre null
        @JsonProperty("externals") TvMazeExternal external,
        TvMazeImage image,
        String summary,
        Long updated,
        @JsonProperty("_links") TvMazeLinks links
) {}
