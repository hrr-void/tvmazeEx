package com.hrr.tvmaze.application.service;

import com.hrr.tvmaze.application.port.in.CreateCommentUseCase;
import com.hrr.tvmaze.application.port.out.CommentRepositoryPort;
import com.hrr.tvmaze.domain.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CreateCommentUseCase {

    private final CommentRepositoryPort port;

    public CommentService(CommentRepositoryPort port){
        this.port = port;
    }

    @Override
    public Comment create(Comment comment) {
        return port.save(comment);
    }

}
