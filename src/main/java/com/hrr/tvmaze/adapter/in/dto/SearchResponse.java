package com.hrr.tvmaze.adapter.in.dto;

import java.util.List;

public record SearchResponse(
        Long id,
        String name,
        String channel,
        String summary,
        List<String> genres,
        List<CommentResponse> comments
) {}
