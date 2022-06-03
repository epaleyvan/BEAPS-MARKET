package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findByName(String string);
}