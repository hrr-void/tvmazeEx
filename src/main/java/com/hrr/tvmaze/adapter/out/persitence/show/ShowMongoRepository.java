package com.hrr.tvmaze.adapter.out.persitence.show;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowMongoRepository extends MongoRepository<ShowDocument, Long> {
}
