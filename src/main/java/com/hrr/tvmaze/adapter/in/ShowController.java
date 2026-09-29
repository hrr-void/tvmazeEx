package com.hrr.tvmaze.adapter.in;

import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import com.hrr.tvmaze.domain.model.Show;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final SearchShowUseCase searchShowUseCase;

    public ShowController(SearchShowUseCase searchShowUseCase){
        this.searchShowUseCase = searchShowUseCase;
    }

    @GetMapping("/search")
    public List<Show> search(@RequestParam("search_querry") String searchQuery){
        return searchShowUseCase.search(searchQuery);
    }

}

