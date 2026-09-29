package com.hrr.tvmaze.adapter.out.tvmaze;

import com.hrr.tvmaze.adapter.out.tvmaze.dto.TvMazeShow;
import com.hrr.tvmaze.domain.model.Show;
import org.springframework.stereotype.Component;

@Component
public class TvMazeShowMapper {

    public Show toDomain(TvMazeShow tvMazeShow){
        return new Show(
                tvMazeShow.id(),
                tvMazeShow.name(),
                resolveChannel(tvMazeShow),
                tvMazeShow.summary(),
                tvMazeShow.genres());
    }

    private String resolveChannel(TvMazeShow show){
        if(show.network() != null){
            return show.network().name();
        }
        if(show.channel() != null){
            return show.channel().name();
        }

        return null;
    }
}
