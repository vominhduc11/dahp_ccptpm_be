package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.Info_userDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Info_user;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Info_userMapper {
    Info_userDTO toInfoUserDto(Info_user info_user);
    Info_user toInfoUser(Info_userDTO info_userDTO);
}
