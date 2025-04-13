package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.GenreDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDTO toGenreDto(Genre genre);
    Genre toGenre(GenreDTO genreDTO);
}
