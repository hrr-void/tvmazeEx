package com.hrr.tvmaze.adapter.out.persitence.show;

import com.hrr.tvmaze.domain.model.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.time.Instant;

@Document(collection = "cache")
public record ShowDocument(
        @Id
        Long id,
        Instant cachedAt,

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

        External external,
        Image image,

        String summary,
        Long updated,
        Links links
) {
}
