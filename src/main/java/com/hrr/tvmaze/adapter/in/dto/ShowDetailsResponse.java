package com.hrr.tvmaze.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hrr.tvmaze.domain.model.ShowDetails;

import java.util.List;

public record ShowDetailsResponse(
        @JsonUnwrapped ShowDetails show,
        List<CommentResponse> comments
) {}
