package com.hrr.tvmaze.infrastructure.common.exception;

public record ErrorResponse(
        int status,
        String message
) {
}
