package com.hrr.tvmaze.adapter.out.persitence.comment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentMongoRepository extends MongoRepository<CommentDocument, String> {
}
