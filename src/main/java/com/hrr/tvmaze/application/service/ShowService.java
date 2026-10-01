package com.hrr.tvmaze.application.service;

import com.hrr.tvmaze.application.port.in.GetShowByIdUseCase;
import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import com.hrr.tvmaze.application.port.out.ShowProviderPort;
import com.hrr.tvmaze.application.port.out.ShowRepositoryPort;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService implements SearchShowUseCase, GetShowByIdUseCase {

    private final ShowProviderPort port;
    private final ShowRepositoryPort repositoryPort;

    public ShowService(ShowProviderPort port, ShowRepositoryPort repositoryPort){
        this.port = port;
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Show> search(String query) {
        return port.search(query);
    }

    @Override
    public ShowDetails getById(Long showId){
        Optional<ShowDetails> cachedShow = repositoryPort.findById(showId);

        if(cachedShow.isPresent()){
            return cachedShow.get();
        }

        ShowDetails showDetails = port.getById(showId);

        repositoryPort.save(showDetails);

        return showDetails;
    }
}
