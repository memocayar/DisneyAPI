package com.disney.disney.service.impl;

import com.disney.disney.dto.GenreDTO;
import com.disney.disney.entity.GenreEntity;
import com.disney.disney.mapper.GenreMapper;
import com.disney.disney.repository.GenderRepository;
import com.disney.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenderRepository genderRepository;

    public GenreDTO save(GenreDTO dto){
        GenreEntity entity = genreMapper.genreDTO2Entity(dto);
        GenreEntity entitySaved = genderRepository.save(entity);
        GenreDTO result = genreMapper.genreEntity2DTO(entitySaved);
        return result;
    }

    public List<GenreDTO> getAllGenres() {
        List<GenreEntity> entities = genderRepository.findAll();
        List<GenreDTO> result = genreMapper.genreEntityList2DTOList(entities);
        return result;
    }
}
