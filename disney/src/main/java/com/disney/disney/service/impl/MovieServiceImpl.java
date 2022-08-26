package com.disney.disney.service.impl;

import com.disney.disney.dto.MovieDTO;
import com.disney.disney.entity.MovieEntity;
import com.disney.disney.mapper.MovieMapper;
import com.disney.disney.repository.MovieRepository;
import com.disney.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO save(MovieDTO dto){
        MovieEntity entity = movieMapper.movieDTO2Entity(dto, true);
        MovieEntity entitySaved = movieRepository.save(entity);
        return movieMapper.movieEntity2DTO(entitySaved,true);
    }

    public List<MovieDTO> getAllMovies(){
        List<MovieEntity> entities = movieRepository.findAll();
        return movieMapper.movieEntityList2DTOList(entities, true);
    }

    public void delete(Long id){
        this.movieRepository.deleteById(id);
    }

    public MovieDTO update(MovieDTO movieDTO, Long id){
        Optional<MovieEntity> entityOptional = movieRepository.findById(movieDTO.getId());

        MovieEntity movieEntity = movieMapper.movieDTO2Entity(movieDTO, false);
        MovieEntity entitySaved = movieRepository.save(movieEntity);
        return movieMapper.movieEntity2DTO(entitySaved, true);
    }
}
