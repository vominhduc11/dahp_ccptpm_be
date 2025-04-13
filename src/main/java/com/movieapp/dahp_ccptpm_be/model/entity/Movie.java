package com.movieapp.dahp_ccptpm_be.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Lob
    @Column(nullable = false)
    String avatar;

    @Lob
    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    long  duration;

    @Column(nullable = false)
    int year;

    @Lob
    @Column(nullable = false)
    String overview;

    @JsonIgnore
    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    Room room;

    @JsonIgnore
    @ManyToMany(mappedBy = "movies")
    List<Cast> carts;

    @JsonIgnore
    @ManyToMany(mappedBy = "movies")
    List<Genre> genres;
}
