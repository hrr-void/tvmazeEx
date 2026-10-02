package com.hrr.tvmaze.domain.model;

import java.util.List;

public record ShowDetailsWithComments(
        ShowDetails show,
        List<Comment> comments
) {
}
