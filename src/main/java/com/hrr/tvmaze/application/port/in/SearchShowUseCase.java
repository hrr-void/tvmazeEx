package com.hrr.tvmaze.application.port.in;

import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;

import java.util.List;

public interface SearchShowUseCase {
    List<Show> search(String query);

    ShowDetails getById(Long showId);
}
