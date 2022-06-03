package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Category;
import com.beapsmarket.webapp.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByReference(String string);
}
