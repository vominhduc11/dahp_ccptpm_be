package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.RoomDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDTO toRoomDto(Room room);
    Room toRoom(RoomDTO roomDTO);
}
