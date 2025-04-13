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
@Entity(name = "user_playing")
public class User_playing {
    @Id
    int id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id_user")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_room")
    Room room;

    @JsonIgnore
    @OneToMany(mappedBy = "userPlaying", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Comment> comments;
}
