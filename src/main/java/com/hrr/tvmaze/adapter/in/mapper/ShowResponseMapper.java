package com.hrr.tvmaze.adapter.in.mapper;

import com.hrr.tvmaze.adapter.in.dto.CommentResponse;
import com.hrr.tvmaze.adapter.in.dto.SearchResponse;
import com.hrr.tvmaze.adapter.in.dto.ShowDetailsResponse;
import com.hrr.tvmaze.domain.model.Comment;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetailsWithComments;
import com.hrr.tvmaze.domain.model.ShowWithComments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowResponseMapper {

    public List<SearchResponse> toSearchResponses(List<ShowWithComments> showsWithComments) {
        return showsWithComments.stream()
                .map(this::toSearchResponse)
                .toList();
    }

    public SearchResponse toSearchResponse(ShowWithComments showWithComments) {
        Show show = showWithComments.show();
        return new SearchResponse(
                show.id(),
                show.name(),
                resolveChannel(show),
                show.summary(),
                show.genres(),
                toCommentResponses(showWithComments.comments())
        );
    }

    public ShowDetailsResponse toShowDetailsResponse(ShowDetailsWithComments showWithComments) {
        return new ShowDetailsResponse(
                showWithComments.show(),
                toCommentResponses(showWithComments.comments())
        );
    }

    private String resolveChannel(Show show) {
        if (show.network() != null) {
            return show.network().name();
        }
        return show.webChannel() != null ? show.webChannel().name() : null;
    }

    private List<CommentResponse> toCommentResponses(List<Comment> comments) {
        return comments.stream()
                .map(comment -> new CommentResponse(comment.comment(), comment.rating()))
                .toList();
    }
}
