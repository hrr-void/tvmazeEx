package com.hrr.tvmaze.application.service;

import com.hrr.tvmaze.application.port.in.GetShowByIdUseCase;
import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import com.hrr.tvmaze.application.port.out.ShowProviderPort;
import com.hrr.tvmaze.application.port.out.ShowRepositoryPort;
import com.hrr.tvmaze.application.port.out.CommentRepositoryPort;
import com.hrr.tvmaze.domain.model.Comment;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;
import com.hrr.tvmaze.domain.model.ShowDetailsWithComments;
import com.hrr.tvmaze.domain.model.ShowWithComments;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowService implements SearchShowUseCase, GetShowByIdUseCase {

    private final ShowProviderPort showProviderPort;
    private final ShowRepositoryPort showRepositoryPort;
    private final CommentRepositoryPort commentRepositoryPort;

    public ShowService(
            ShowProviderPort showProviderPort,
            ShowRepositoryPort showRepositoryPort,
            CommentRepositoryPort commentRepositoryPort
    ){
        this.showProviderPort = showProviderPort;
        this.showRepositoryPort = showRepositoryPort;
        this.commentRepositoryPort = commentRepositoryPort;
    }

    @Override
    public List<ShowWithComments> search(String query) {
        List<Show> shows = showProviderPort.search(query);
        List<Long> showIds = shows.stream().map(Show::id).toList();
        Map<Long, List<Comment>> commentsByShowId = commentRepositoryPort.findByShowIds(showIds)
                .stream()
                .collect(Collectors.groupingBy(Comment::showId));

        return shows.stream()
                .map(show -> new ShowWithComments(
                        show,
                        commentsByShowId.getOrDefault(show.id(), List.of())
                ))
                .toList();
    }

    @Override
    public ShowDetailsWithComments getById(Long showId){
        Optional<ShowDetails> cachedShow = showRepositoryPort.findById(showId);
        ShowDetails showDetails;
        if(cachedShow.isPresent()){
            showDetails = cachedShow.get();
        } else {
            showDetails = showProviderPort.getById(showId);
            showRepositoryPort.save(showDetails);
        }

        List<Comment> comments = commentRepositoryPort.findByShowIds(List.of(showId));

        return new ShowDetailsWithComments(showDetails, comments);
    }
}
