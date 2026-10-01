package com.hrr.tvmaze.application.port.out;

import com.hrr.tvmaze.domain.model.Comment;

public interface CommentRepositoryPort {
    Comment save(Comment comment);
}
