package com.hrr.tvmaze.adapter.in.dto;

import com.hrr.tvmaze.domain.model.Comment;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowWithComments;

import java.util.List;

public record SearchShowResponse(
        Long id,
        String name,
        String channel,
        String summary,
        List<String> genres,
        List<CommentResponse> comments
) {
    public static SearchShowResponse from(ShowWithComments showWithComments) {
        Show show = showWithComments.show();
        String channel = show.network() != null
                ? show.network().name()
                : show.webChannel() != null ? show.webChannel().name() : null;

        return new SearchShowResponse(
                show.id(),
                show.name(),
                channel,
                show.summary(),
                show.genres(),
                showWithComments.comments().stream().map(CommentResponse::from).toList()
        );
    }

    public record CommentResponse(String comment, Integer rating) {
        private static CommentResponse from(Comment comment) {
            return new CommentResponse(comment.comment(), comment.rating());
        }
    }
}
