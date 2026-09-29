package com.hrr.tvmaze.application.port.in;

import com.hrr.tvmaze.domain.model.Show;
import java.util.List;

public interface SearchShowUseCase {
    List<Show> search(String query);
}
