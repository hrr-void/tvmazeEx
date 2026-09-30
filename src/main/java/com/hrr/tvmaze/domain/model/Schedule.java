package com.hrr.tvmaze.domain.model;

import java.util.List;

public record Schedule(
        String time,
        List<String> days
) {
}
