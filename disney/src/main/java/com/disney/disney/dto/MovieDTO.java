package com.disney.disney.dto;

import com.disney.disney.entity.CharacterEntity;
import com.disney.disney.entity.GenreEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String image;
    private String title;
    private String creationDate;
    private Integer rate;
    private Long genreId;
    private List<CharacterDTO> characters;
}
