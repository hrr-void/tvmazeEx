package com.hrr.tvmaze.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hrr.tvmaze.domain.model.Comment;
import com.hrr.tvmaze.domain.model.ShowDetails;
import com.hrr.tvmaze.domain.model.ShowDetailsWithComments;

import java.util.List;

public record ShowDetailsResponse(
        @JsonUnwrapped ShowDetails show,
        List<CommentResponse> comments
) {
    public static ShowDetailsResponse from(ShowDetailsWithComments showWithComments) {
        return new ShowDetailsResponse(
                showWithComments.show(),
                showWithComments.comments().stream().map(CommentResponse::from).toList()
        );
    }

    public record CommentResponse(String comment, Integer rating) {
        private static CommentResponse from(Comment comment) {
            return new CommentResponse(comment.comment(), comment.rating());
        }
    }
}
