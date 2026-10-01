package com.hrr.tvmaze.application.port.in;

import com.hrr.tvmaze.domain.model.Comment;

public interface CreateCommentUseCase {
    void create(Comment comment);
}
