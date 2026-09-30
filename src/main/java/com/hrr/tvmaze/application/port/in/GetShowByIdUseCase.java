package com.hrr.tvmaze.application.port.in;

import com.hrr.tvmaze.domain.model.ShowDetails;

public interface GetShowByIdUseCase {
    ShowDetails getById(Long id);
}
