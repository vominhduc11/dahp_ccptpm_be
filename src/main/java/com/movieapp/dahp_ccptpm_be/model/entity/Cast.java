package com.movieapp.dahp_ccptpm_be.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "cast")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, length = 50)
    String name;

    @Lob
    @Column(nullable = false)
    String avatar;

    @ManyToMany
    @JoinTable(name = "cast_movie", joinColumns = @JoinColumn(name = "id_cast"), inverseJoinColumns = @JoinColumn(name = "id_movie"))
    private List<Movie> movies;
}
