package com.hrr.tvmaze.adapter.out.persitence.comment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public record CommentDocument(
        @Id
        String id,
        Long showId,
        String comment,
        Integer rating
) {
}
