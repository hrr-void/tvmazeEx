package com.hrr.tvmaze.adapter.out;

import com.hrr.tvmaze.adapter.out.persitence.comment.CommentMongoMapper;
import com.hrr.tvmaze.adapter.out.persitence.comment.CommentDocument;
import com.hrr.tvmaze.adapter.out.persitence.comment.CommentMongoRepository;
import com.hrr.tvmaze.application.port.out.CommentRepositoryPort;
import com.hrr.tvmaze.domain.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CreateMongoAdapter implements CommentRepositoryPort {

    private CommentMongoRepository repository;
    private CommentMongoMapper mapper;

    public CreateMongoAdapter(CommentMongoRepository repository, CommentMongoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Comment save(Comment comment) {
        CommentDocument document = mapper.toDocument(comment);
        CommentDocument saved = repository.save(document);
        return mapper.toDomain(saved);
    }
}
