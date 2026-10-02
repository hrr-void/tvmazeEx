package com.hrr.tvmaze.application.port.out;

import com.hrr.tvmaze.domain.model.ShowDetails;
import java.util.Optional;

public interface ShowRepositoryPort {

    Optional<ShowDetails> findById(Long id);

    void save(ShowDetails show);
}
