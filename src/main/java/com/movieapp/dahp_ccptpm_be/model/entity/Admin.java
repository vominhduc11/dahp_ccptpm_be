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
@Entity(name = "admin")
public class Admin{
    @Id
    int id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id_account")
    Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Room> rooms;
}
