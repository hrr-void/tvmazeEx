package com.hrr.tvmaze.application.port.out;

import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;

import java.util.List;

public interface ShowProviderPort {

    List<Show> search(String query);

    ShowDetails getById(Long showId);
}
