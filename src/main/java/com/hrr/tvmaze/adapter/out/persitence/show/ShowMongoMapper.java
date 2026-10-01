package com.hrr.tvmaze.adapter.out.persitence.show;

import com.hrr.tvmaze.domain.model.ShowDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShowMongoMapper {
    public ShowDetails toDomain(ShowDocument document);

    public ShowDocument toDocument(ShowDetails details);
}
