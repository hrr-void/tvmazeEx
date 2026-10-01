package com.hrr.tvmaze.application.port.in;

import com.hrr.tvmaze.domain.model.ShowWithComments;
import com.hrr.tvmaze.domain.model.ShowDetails;

import java.util.List;

public interface SearchShowUseCase {
    List<ShowWithComments> search(String query);
}
