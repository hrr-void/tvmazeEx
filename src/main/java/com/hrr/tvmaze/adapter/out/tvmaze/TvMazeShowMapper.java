package com.hrr.tvmaze.adapter.out.tvmaze;

import com.hrr.tvmaze.adapter.out.tvmaze.dto.TvMazeShowDetails;
import com.hrr.tvmaze.domain.model.Show;
import com.hrr.tvmaze.domain.model.ShowDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TvMazeShowMapper {

    Show toSearchDomain(TvMazeShowDetails show);

    ShowDetails toDetailsDomain(TvMazeShowDetails showDetails);
}
