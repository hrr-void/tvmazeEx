package com.hrr.tvmaze.adapter.out.persitence.show;

import com.hrr.tvmaze.application.port.out.ShowRepositoryPort;
import com.hrr.tvmaze.domain.model.ShowDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShowMongoAdapter implements ShowRepositoryPort {

    private final ShowMongoRepository repository;
    private final ShowMongoMapper mapper;

    public ShowMongoAdapter(ShowMongoRepository repository, ShowMongoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ShowDetails> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public ShowDetails save(ShowDetails show) {
        ShowDocument document = mapper.toDocument(show);
        ShowDocument saved = repository.save(document);
        return mapper.toDomain(saved);
    }
}
