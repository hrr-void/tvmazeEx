package com.hrr.tvmaze.adapter.out.persitence.comment;

import com.hrr.tvmaze.domain.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMongoMapper {
    Comment toDomain(CommentDocument document);

    CommentDocument toDocument(Comment comment);
}
