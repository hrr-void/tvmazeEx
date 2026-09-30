package com.hrr.tvmaze.domain.model;

import java.time.LocalDateTime;

public record Country(
        String name,
        String code,
        String timezone
) {
}
