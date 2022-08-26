package com.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

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

    @OneToMany(fetch = FetchType.LAZY)
    private List<MovieEntity> movies = new ArrayList<>();

    private boolean delete = Boolean.FALSE;

    public GenreEntity() {
    }
}
