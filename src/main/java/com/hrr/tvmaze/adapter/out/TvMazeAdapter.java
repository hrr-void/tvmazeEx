package com.hrr.tvmaze.adapter.out;

import com.hrr.tvmaze.adapter.out.tvmaze.TvMazeShowMapper;
import com.hrr.tvmaze.adapter.out.tvmaze.dto.TvMazeSearchResult;
import com.hrr.tvmaze.adapter.out.tvmaze.dto.TvMazeShowDetails;
import com.hrr.tvmaze.application.port.out.ShowProviderPort;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Component
public class TvMazeAdapter implements ShowProviderPort {

    private final RestClient client;
    private final TvMazeShowMapper mapper;

    public TvMazeAdapter(RestClient client, TvMazeShowMapper mapper){
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public List<Show> search(String query) {
        TvMazeSearchResult[] results = client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/shows")
                        .queryParam("q", query)
                        .build())
                .retrieve()
                .body(TvMazeSearchResult[].class);

        if(results == null){
            return List.of();
        }

        return Arrays.stream(results).map(TvMazeSearchResult::show).map(mapper::toDomain).toList();
    }

    @Override
    public ShowDetails getById(Long showId) {
        TvMazeShowDetails response = client
                .get()
                .uri("/shows/{id}", showId)
                .retrieve()
                .body(TvMazeShowDetails.class);

        return mapper.toDomain(response);
    }

}
