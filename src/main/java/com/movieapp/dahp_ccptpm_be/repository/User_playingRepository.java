package com.movieapp.dahp_ccptpm_be.repository;

import com.movieapp.dahp_ccptpm_be.model.entity.User_playing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_playingRepository extends JpaRepository<User_playing, Integer> {
}
