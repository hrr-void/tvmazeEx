package com.hrr.tvmaze.adapter.out.persitence.show;

import com.hrr.tvmaze.domain.model.ShowDetails;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ShowMongoMapper {
    public ShowDetails toDomain(ShowDocument document);

    @Mapping(target = "cachedAt", source = "cachedAt")
    public ShowDocument toDocument(ShowDetails details, Instant cachedAt);
}
