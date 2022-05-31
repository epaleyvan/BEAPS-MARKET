package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByReference(String string);
}
