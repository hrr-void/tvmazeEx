package com.hrr.tvmaze.adapter.out.persitence.show;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.Optional;

public interface ShowMongoRepository extends MongoRepository<ShowDocument, Long> {

    Optional<ShowDocument> findByIdAndCachedAtAfter(Long id, Instant cachedAt);
}
