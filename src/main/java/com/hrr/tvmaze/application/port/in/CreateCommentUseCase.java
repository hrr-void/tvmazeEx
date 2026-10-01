package com.hrr.tvmaze.application.port.in;

import com.hrr.tvmaze.domain.model.Comment;

public interface CreateCommentUseCase {
    Comment create(Comment comment);
}
