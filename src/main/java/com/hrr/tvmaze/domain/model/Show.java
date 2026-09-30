package com.hrr.tvmaze.domain.model;

import java.util.List;

public record Show(
        Long id,
        String name,
        List<String> genres,
        Network network,
        WebChannel webChannel,
        String summary
) {
}