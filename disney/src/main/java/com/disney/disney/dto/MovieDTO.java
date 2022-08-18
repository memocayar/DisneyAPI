package com.disney.disney.dto;

import com.disney.disney.entity.CharacterEntity;
import com.disney.disney.entity.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String image;
    private String title;
    /*
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;*/
    private Integer rate;

    /*

    QUÉ HAGO CON ESTOS EN LOS DTO/SERVICE/MAPPER

    private Set<CharacterEntity> characters;
    private GenreEntity genre; */

}
