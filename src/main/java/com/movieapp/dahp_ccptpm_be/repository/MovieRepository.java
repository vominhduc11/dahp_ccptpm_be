package com.movieapp.dahp_ccptpm_be.repository;

import com.movieapp.dahp_ccptpm_be.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
