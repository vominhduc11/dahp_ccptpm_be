package com.movieapp.dahp_ccptpm_be.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Lob
    @Column(nullable = false)
    String content;

    @Column(nullable = false)
    ZonedDateTime timeAgo;

    @ManyToOne
    @JoinColumn(name = "id_room")
    Room room;

    @ManyToOne
    @JoinColumn(name = "id_user_playing")
    User_playing userPlaying;
}
