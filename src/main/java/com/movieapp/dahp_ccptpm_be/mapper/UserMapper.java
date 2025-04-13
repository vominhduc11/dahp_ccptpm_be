package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.UserDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDto(User user);
    User toUser(UserDTO userDTO);
}
