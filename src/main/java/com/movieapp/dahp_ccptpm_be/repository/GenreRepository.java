package com.movieapp.dahp_ccptpm_be.repository;

import com.movieapp.dahp_ccptpm_be.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
