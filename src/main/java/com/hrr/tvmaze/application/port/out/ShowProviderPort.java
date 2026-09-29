package com.hrr.tvmaze.application.port.out;

import com.hrr.tvmaze.domain.model.Show;

import java.util.List;

public interface ShowProviderPort {
    List<Show> search(String searchQuerry);
}
