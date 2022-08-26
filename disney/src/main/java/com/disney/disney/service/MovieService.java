package com.disney.disney.service;

import com.disney.disney.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieDTO> getAllMovies();

    void delete(Long id);

    MovieDTO update(MovieDTO movieDTO, Long id);
}
