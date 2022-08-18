package com.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "genre")
public class GenreEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String Name;

    private String image;

    @OneToMany
    private List<MovieEntity> movies = new ArrayList<>();

    private boolean delete;

    public GenreEntity() {
    }
}
