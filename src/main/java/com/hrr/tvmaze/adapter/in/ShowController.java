package com.hrr.tvmaze.adapter.in;

import com.hrr.tvmaze.adapter.in.dto.SearchShowResponse;
import com.hrr.tvmaze.application.port.in.GetShowByIdUseCase;
import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import com.hrr.tvmaze.domain.model.ShowDetails;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final SearchShowUseCase searchShowUseCase;
    private final GetShowByIdUseCase getShowByIdUseCase;

    public ShowController(SearchShowUseCase searchShowUseCase, GetShowByIdUseCase getShowByIdUseCase){
        this.searchShowUseCase = searchShowUseCase;
        this.getShowByIdUseCase = getShowByIdUseCase;
    }

    @GetMapping("/search")
    public List<SearchShowResponse> search(
            @RequestParam("query")
            @NotBlank
            String query){
        return searchShowUseCase.search(query)
                .stream()
                .map(SearchShowResponse::from)
                .toList();
    }

    @GetMapping("/{showId}")
    public ShowDetails getById(
            @PathVariable("showId")
            @Positive
            Long showId){
        return getShowByIdUseCase.getById(showId);
    }
}