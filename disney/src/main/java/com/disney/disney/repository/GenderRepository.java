package com.disney.disney.repository;

import com.disney.disney.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<GenreEntity, Long> {
}
