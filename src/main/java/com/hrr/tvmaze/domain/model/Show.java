package com.hrr.tvmaze.domain.model;

import java.util.List;

// agregar validaciones
public record Show(
        Long id,
        String name,
        String channel,
        String summary,
        List<String> genres
) {
}
