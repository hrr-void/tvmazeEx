package com.hrr.tvmaze.adapter.in;

import com.hrr.tvmaze.adapter.in.dto.CreateCommentRequest;
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

    public CommentController(CreateCommentUseCase createCommentUseCase){
        this.createCommentUseCase = createCommentUseCase;
    }

    @PostMapping
    public ResponseEntity<Comment> create(
            @Valid
            @RequestBody
            CreateCommentRequest request){
        Comment comment = new Comment(
                request.showId(),
                request.comment(),
                request.rating()
        );
        createCommentUseCase.create(comment);

        return ResponseEntity.status(HttpStatus.OK).body(comment);
    }
}
