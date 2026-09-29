package com.hrr.tvmaze.application.service;

import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import com.hrr.tvmaze.application.port.out.ShowProviderPort;
import com.hrr.tvmaze.domain.model.Show;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShowService implements SearchShowUseCase {

    private final ShowProviderPort port;

    public ShowService(ShowProviderPort port){
        this.port = port;
    }

    @Override
    public List<Show> search(String seachQuerry) {
        return port.search(seachQuerry);
    }
}
