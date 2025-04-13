package com.movieapp.dahp_ccptpm_be.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "info_user")
public class Info_user {
    @Id
    int id;

    @Column(nullable = false, length = 50)
    String phone;

    @Column(nullable = false, length = 50)
    String name;

    @Column(nullable = false, length = 50)
    String avatar;

    @Column(nullable = false, length = 50)
    String address;

    @Column(nullable = false, length = 50)
    String email;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id_user")
    User user;
}
