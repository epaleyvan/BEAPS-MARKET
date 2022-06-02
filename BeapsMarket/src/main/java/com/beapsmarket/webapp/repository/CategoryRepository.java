package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
