package com.hrr.tvmaze.application.service;

import com.hrr.tvmaze.application.port.in.GetShowByIdUseCase;
import com.hrr.tvmaze.application.port.in.SearchShowUseCase;
import com.hrr.tvmaze.application.port.out.ShowProviderPort;
import com.hrr.tvmaze.application.port.out.ShowRepositoryPort;
import com.hrr.tvmaze.application.port.out.CommentRepositoryPort;
import com.hrr.tvmaze.domain.model.Comment;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;
import com.hrr.tvmaze.domain.model.ShowWithComments;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowService implements SearchShowUseCase, GetShowByIdUseCase {

    private final ShowProviderPort port;
    private final ShowRepositoryPort repositoryPort;
    private final CommentRepositoryPort commentRepositoryPort;

    public ShowService(
            ShowProviderPort port,
            ShowRepositoryPort repositoryPort,
            CommentRepositoryPort commentRepositoryPort
    ){
        this.port = port;
        this.repositoryPort = repositoryPort;
        this.commentRepositoryPort = commentRepositoryPort;
    }

    @Override
    public List<ShowWithComments> search(String query) {
        List<Show> shows = port.search(query);
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
