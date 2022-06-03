package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Set<Product>> findByName(String string);

    Product findByReference(String string);

    void deleteByReference(String string);

    boolean existsByReference(String string);
}