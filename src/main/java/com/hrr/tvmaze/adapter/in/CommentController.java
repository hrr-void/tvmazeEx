package com.hrr.tvmaze.adapter.in;

import com.hrr.tvmaze.adapter.in.dto.CreateCommentRequest;
import com.hrr.tvmaze.adapter.in.mapper.CommentRequestMapper;
import com.hrr.tvmaze.application.port.in.CreateCommentUseCase;
import com.hrr.tvmaze.domain.model.Comment;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CreateCommentUseCase createCommentUseCase;
    private final CommentRequestMapper commentRequestMapper;

    public CommentController(CreateCommentUseCase createCommentUseCase, CommentRequestMapper commentRequestMapper){
        this.createCommentUseCase = createCommentUseCase;
        this.commentRequestMapper = commentRequestMapper;
    }

    @PostMapping
    public ResponseEntity<Comment> create(
            @Valid
            @RequestBody
            CreateCommentRequest request){
        Comment savedComment = createCommentUseCase.create(commentRequestMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }
}
