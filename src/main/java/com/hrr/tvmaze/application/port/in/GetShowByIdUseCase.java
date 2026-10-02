package com.hrr.tvmaze.application.port.in;

import com.hrr.tvmaze.domain.model.ShowDetailsWithComments;

public interface GetShowByIdUseCase {
    ShowDetailsWithComments getById(Long id);
}
