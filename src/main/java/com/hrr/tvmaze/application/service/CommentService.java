package com.hrr.tvmaze.application.service;

import com.hrr.tvmaze.application.port.in.CreateCommentUseCase;
import com.hrr.tvmaze.application.port.in.EnsureShowExistsUseCase;
import com.hrr.tvmaze.application.port.out.CommentRepositoryPort;
import com.hrr.tvmaze.domain.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CreateCommentUseCase {

    private final CommentRepositoryPort port;
    private final EnsureShowExistsUseCase ensureShowExistsUseCase;

    public CommentService(CommentRepositoryPort port, EnsureShowExistsUseCase ensureShowExistsUseCase){
        this.port = port;
        this.ensureShowExistsUseCase = ensureShowExistsUseCase;
    }

    @Override
    public Comment create(Comment comment) {
        ensureShowExistsUseCase.ensureExists(comment.showId());
        return port.save(comment);
    }

}
