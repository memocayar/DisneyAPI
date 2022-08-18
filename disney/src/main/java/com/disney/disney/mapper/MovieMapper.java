package com.disney.disney.mapper;

import com.disney.disney.dto.MovieDTO;
import com.disney.disney.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    public MovieEntity movieDTO2Entity(MovieDTO dto){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImage(dto.getImage());
        movieEntity.setTitle(dto.getTitle());
        //movieEntity.setCreationDate(dto.getCreationDate());
        movieEntity.setRate(dto.getRate());
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity){
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        //dto.setCreationDate(entity.getCreationDate());
        dto.setRate(entity.getRate());

        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities){
        List<MovieDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities){
            dtos.add(this.movieEntity2DTO(entity));
        }
        return dtos;
    }
}
