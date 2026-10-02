package com.hrr.tvmaze.adapter.out.persitence.show;

import com.hrr.tvmaze.application.port.out.ShowRepositoryPort;
import com.hrr.tvmaze.domain.model.ShowDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

@Component
public class ShowMongoAdapter implements ShowRepositoryPort {

    private final ShowMongoRepository repository;
    private final ShowMongoMapper mapper;
    private final Duration cacheTtl;

    public ShowMongoAdapter(
            ShowMongoRepository repository,
            ShowMongoMapper mapper,
            @Value("${tvmaze.cache.ttl:PT24H}") Duration cacheTtl
    ){
        this.repository = repository;
        this.mapper = mapper;
        this.cacheTtl = cacheTtl;
    }

    @Override
    public Optional<ShowDetails> findById(Long id) {
        return repository.findByIdAndCachedAtAfter(id, Instant.now().minus(cacheTtl))
                .map(mapper::toDomain);
    }

    @Override
    public void save(ShowDetails show) {
        repository.save(mapper.toDocument(show, Instant.now()));
    }
}
