package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.MovieDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO toMovieDto(Movie movie);
    Movie toMovie(MovieDTO movieDTO);
}
