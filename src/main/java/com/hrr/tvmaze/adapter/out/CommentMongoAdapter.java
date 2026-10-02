package com.hrr.tvmaze.adapter.out;

import com.hrr.tvmaze.adapter.out.persitence.comment.CommentMongoMapper;
import com.hrr.tvmaze.adapter.out.persitence.comment.CommentDocument;
import com.hrr.tvmaze.adapter.out.persitence.comment.CommentMongoRepository;
import com.hrr.tvmaze.application.port.out.CommentRepositoryPort;
import com.hrr.tvmaze.domain.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentMongoAdapter implements CommentRepositoryPort {

    private CommentMongoRepository repository;
    private CommentMongoMapper mapper;

    public CommentMongoAdapter(CommentMongoRepository repository, CommentMongoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Comment save(Comment comment) {
        CommentDocument document = mapper.toDocument(comment);
        CommentDocument saved = repository.save(document);
        return mapper.toDomain(saved);
    }

    @Override
    public List<Comment> findByShowIds(List<Long> showIds) {
        if (showIds.isEmpty()) {
            return List.of();
        }

        return repository.findByShowIdIn(showIds)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
