package com.hrr.tvmaze.domain.model;

import java.util.List;

public record ShowDetails(
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
        Schedule schedule,
        Rating rating,
        Double weight,
        Network network,
        WebChannel webChannel,
        //dvdContri siempre null
        External external,
        Image image,
        String summary,
        Long updated,
        Links links
) {}