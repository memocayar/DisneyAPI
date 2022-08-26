package com.disney.disney.dto;

import com.disney.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CharacterDTO {
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Float weight;
    private String history;
    private List<MovieDTO> movies;
}
