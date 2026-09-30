package com.hrr.tvmaze.adapter.in;

import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final SearchShowUseCase searchShowUseCase;

    public ShowController(SearchShowUseCase searchShowUseCase){
        this.searchShowUseCase = searchShowUseCase;
    }

    @GetMapping("/search")
    public List<Show> search(
            @RequestParam("query")
            @NotBlank
            String query){
        return searchShowUseCase.search(query);
    }

    @GetMapping("/{showId}")
    public ShowDetails getById(
            @PathVariable("showId")
            @Positive
            Long showId){
        return searchShowUseCase.getById(showId);
    }

}

