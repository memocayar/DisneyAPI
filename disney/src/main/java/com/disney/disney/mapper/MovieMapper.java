package com.disney.disney.mapper;

import com.disney.disney.dto.CharacterDTO;
import com.disney.disney.dto.MovieBasicDTO;
import com.disney.disney.dto.MovieDTO;
import com.disney.disney.entity.CharacterEntity;
import com.disney.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;
    public MovieEntity movieDTO2Entity(MovieDTO dto, boolean loadCharacters){
        MovieEntity movieEntity = new MovieEntity();
        if(dto.getId() != null){
            movieEntity.setId(dto.getId());
        }
        movieEntity.setImage(dto.getImage());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setCreationDate(
                this.string2LocalDate(dto.getCreationDate())
        );
        movieEntity.setRate(dto.getRate());
        movieEntity.setGenreId(dto.getGenreId());

        if(loadCharacters == true){
            List<CharacterDTO> characterDTOList = dto.getCharacters();
            List<CharacterEntity> characterEntities = characterMapper.characterDTO2EntityList(characterDTOList, false);
            movieEntity.setCharacters(characterEntities);
        }
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters){
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate().toString());
        dto.setRate(entity.getRate());
        dto.setGenreId(entity.getGenreId());
        if (loadCharacters == true) {
            List<CharacterEntity> characterEntities = (List<CharacterEntity>) entity.getCharacters();
            List<CharacterDTO> characterDTOList = characterMapper.characterEntityList2DTOList(characterEntities, false);
            dto.setCharacters(characterDTOList);
        }
        return dto;
    }

    private LocalDate string2LocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters){
        List<MovieDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities){
            dtos.add(this.movieEntity2DTO(entity, loadCharacters));
        }
        return dtos;
    }

    public List<MovieEntity> movieDTO2EntityList(List<MovieDTO> dtos, boolean loadCharacters){
        List<MovieEntity> entities = new ArrayList<>();

        for (MovieDTO dto : dtos){
            entities.add(movieDTO2Entity(dto, loadCharacters));
        }

        return entities;
    }
    public List<MovieBasicDTO> movieEntityList2BasicDTOList(Collection<MovieEntity> entities){
        List<MovieBasicDTO> dtos = new ArrayList<>();
        MovieBasicDTO basicDTO;

        for (MovieEntity entity : entities){
            basicDTO = new MovieBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImage(entity.getImage());
            basicDTO.setTitle(entity.getTitle());
            dtos.add(basicDTO);
        }
        return dtos;
    }
}
