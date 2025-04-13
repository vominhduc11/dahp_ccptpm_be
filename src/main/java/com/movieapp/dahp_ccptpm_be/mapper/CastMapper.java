package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.CastDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Cast;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CastMapper {
    CastDTO toCastDto(Cast cast);
    Cast toCast(CastDTO castDTO);
}
