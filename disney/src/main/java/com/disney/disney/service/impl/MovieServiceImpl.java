package com.disney.disney.service.impl;

import com.disney.disney.dto.MovieDTO;
import com.disney.disney.entity.MovieEntity;
import com.disney.disney.mapper.MovieMapper;
import com.disney.disney.repository.MovieRepository;
import com.disney.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository
            movieRepository;

    public MovieDTO save(MovieDTO dto){
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySaved = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved);
        return result;
    }

    public List<MovieDTO> getAllMovies(){
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities);
        return result;
    }

}
