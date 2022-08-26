package com.disney.disney.mapper;

import com.disney.disney.dto.CharacterBasicDTO;
import com.disney.disney.dto.CharacterDTO;
import com.disney.disney.dto.MovieDTO;
import com.disney.disney.entity.CharacterEntity;
import com.disney.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    @Autowired
    MovieMapper movieMapper;

    public CharacterEntity characterDTO2Entity(CharacterDTO dto, boolean loadMovies){
        CharacterEntity characterEntity = new CharacterEntity();

        if(dto.getId() != null){
            characterEntity.setId(dto.getId());
        }
        characterEntity.setImage(dto.getImage());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());

        if(loadMovies){
            List<MovieDTO> movieDTOS = dto.getMovies();
            List<MovieEntity> movieEntities = movieMapper.movieDTO2EntityList(movieDTOS, false);
            characterEntity.setMovies(movieEntities);
        }

        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies){
        CharacterDTO dto = new CharacterDTO();

        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());
        if (loadMovies){
            List<MovieEntity> movieEntities = entity.getMovies();
            List<MovieDTO> movieDTOS = movieMapper.movieEntityList2DTOList(movieEntities, false);
            dto.setMovies(movieDTOS);
        }
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadMovies){
        List<CharacterDTO> dtos = new ArrayList<>();
        for (CharacterEntity entity : entities){
            dtos.add(this.characterEntity2DTO(entity, true));
        }
        return dtos;
    }

    public List<CharacterEntity> characterDTO2EntityList(List<CharacterDTO> characterDTOS, boolean loadMovies) {
        List<CharacterEntity> characterEntities = new ArrayList<>();

        for (CharacterDTO dto : characterDTOS
        ) {
            characterEntities.add(characterDTO2Entity(dto, true));
        }

        return characterEntities;
    }

    public CharacterBasicDTO characterEntity2BasicDTO(CharacterEntity entity){

        CharacterBasicDTO basicDTO = new CharacterBasicDTO();

        basicDTO.setId(entity.getId());
        basicDTO.setName(entity.getName());
        basicDTO.setImage(entity.getImage());

        return basicDTO;
    }

    public List<CharacterBasicDTO> characterEntity2BasicDTOList(List<CharacterEntity> characterEntities){
        List<CharacterBasicDTO> basicDTOS = new ArrayList<>();

        for(CharacterEntity characterEntity : characterEntities){
            basicDTOS.add(characterEntity2BasicDTO(characterEntity));
        }
        return basicDTOS;
    }
}
