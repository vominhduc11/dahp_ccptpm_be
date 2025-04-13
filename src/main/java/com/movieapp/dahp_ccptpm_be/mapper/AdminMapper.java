package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.AdminDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDTO toAdminDto(Admin admin);
    Admin toAdmin(AdminDTO adminDTO);
}
