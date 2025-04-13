package com.movieapp.dahp_ccptpm_be.repository;

import com.movieapp.dahp_ccptpm_be.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
