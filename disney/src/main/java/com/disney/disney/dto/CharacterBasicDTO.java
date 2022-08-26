package com.disney.disney.dto;

import com.disney.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterBasicDTO {
    private Long id;
    private String image;
    private String name;
}
