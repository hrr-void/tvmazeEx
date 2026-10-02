package com.hrr.tvmaze.adapter.in;

import com.hrr.tvmaze.adapter.in.dto.SearchResponse;
import com.hrr.tvmaze.adapter.in.dto.ShowDetailsResponse;
import com.hrr.tvmaze.adapter.in.mapper.ShowResponseMapper;
import com.hrr.tvmaze.application.port.in.GetShowByIdUseCase;
import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final SearchShowUseCase searchShowUseCase;
    private final GetShowByIdUseCase getShowByIdUseCase;
    private final ShowResponseMapper showResponseMapper;

    public ShowController(
            SearchShowUseCase searchShowUseCase,
            GetShowByIdUseCase getShowByIdUseCase,
            ShowResponseMapper showResponseMapper
    ){
        this.searchShowUseCase = searchShowUseCase;
        this.getShowByIdUseCase = getShowByIdUseCase;
        this.showResponseMapper = showResponseMapper;
    }

    @GetMapping("/search")
    public ResponseEntity<List<SearchResponse>> search(
            @RequestParam("query")
            @NotBlank
            String query){
        return ResponseEntity.ok(showResponseMapper.toSearchResponses(searchShowUseCase.search(query)));
    }

    @GetMapping("/{showId}")
    public ResponseEntity<ShowDetailsResponse> getById(
            @PathVariable("showId")
            @Positive
            Long showId){
        return ResponseEntity.ok(showResponseMapper.toShowDetailsResponse(getShowByIdUseCase.getById(showId)));
    }
}
