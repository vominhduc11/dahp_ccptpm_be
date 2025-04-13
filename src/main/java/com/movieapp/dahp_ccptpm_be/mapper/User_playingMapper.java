package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.User_playingDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.User_playing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface User_playingMapper {
    User_playingDTO toUserPlayingDto(User_playing user_playing);
    User_playing toUserPlaying(User_playingDTO user_playingDTO);
}
