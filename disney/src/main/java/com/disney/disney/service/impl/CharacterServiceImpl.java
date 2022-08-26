package com.disney.disney.service.impl;

import com.disney.disney.dto.CharacterBasicDTO;
import com.disney.disney.dto.CharacterDTO;
import com.disney.disney.entity.CharacterEntity;
import com.disney.disney.mapper.CharacterMapper;
import com.disney.disney.repository.CharacterRepository;
import com.disney.disney.service.CharacterService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO save(CharacterDTO dto){
        CharacterEntity entity = characterMapper.characterDTO2Entity(dto, true);
        CharacterEntity entitySaved = characterRepository.save(entity);
        return characterMapper.characterEntity2DTO(entitySaved, true);
    }

    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> entities = characterRepository.findAll();
        return characterMapper.characterEntityList2DTOList(entities, true);
    }

    public void delete(Long id){
        this.characterRepository.deleteById(id);
    }

    public CharacterDTO update(CharacterDTO characterDTO, Long id){
        Optional<CharacterEntity> entityOptional = characterRepository.findById(characterDTO.getId());

        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(characterDTO, false);
        CharacterEntity entitySaved = characterRepository.save(characterEntity);
        return characterMapper.characterEntity2DTO(entitySaved, true);
    }
}
