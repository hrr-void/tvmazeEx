package com.hrr.tvmaze.adapter.out.persitence.comment;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentMongoRepository extends MongoRepository<CommentDocument, String> {

    List<CommentDocument> findByShowIdIn(List<Long> showIds);
}
