package com.hrr.tvmaze.application.service;

import com.hrr.tvmaze.application.port.in.GetShowByIdUseCase;
import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import com.hrr.tvmaze.application.port.out.ShowProviderPort;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShowService implements SearchShowUseCase, GetShowByIdUseCase {

    private final ShowProviderPort port;

    public ShowService(ShowProviderPort port){
        this.port = port;
    }

    @Override
    public List<Show> search(String query) {
        return port.search(query);
    }

    @Override
    public ShowDetails getById(Long showId){
        return port.getById(showId);
    }
}
