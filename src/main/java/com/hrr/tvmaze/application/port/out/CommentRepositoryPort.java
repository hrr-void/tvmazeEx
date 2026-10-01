package com.hrr.tvmaze.application.port.out;

import com.hrr.tvmaze.domain.model.Comment;

import java.util.List;

public interface CommentRepositoryPort {
    Comment save(Comment comment);

    List<Comment> findByShowIds(List<Long> showIds);
}
