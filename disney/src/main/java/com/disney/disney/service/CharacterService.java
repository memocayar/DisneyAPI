package com.disney.disney.service;

import com.disney.disney.dto.CharacterBasicDTO;
import com.disney.disney.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO save(CharacterDTO dto);

    List<CharacterDTO> getAllCharacters();

    void delete(Long id);

    CharacterDTO update(CharacterDTO characterDTO, Long id);

}
