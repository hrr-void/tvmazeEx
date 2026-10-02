package com.hrr.tvmaze.adapter.in.mapper;

import com.hrr.tvmaze.adapter.in.dto.CreateCommentRequest;
import com.hrr.tvmaze.domain.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentRequestMapper {

    public Comment toDomain(CreateCommentRequest request) {
        return new Comment(request.showId(), request.comment(), request.rating());
    }
}
