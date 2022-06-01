package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.dto.CategoryDto;
import com.beapsmarket.webapp.model.entities.Category;
import com.beapsmarket.webapp.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional <Product>findProductByReference(String reference);
   Optional <Set<Product>> findProductByCategory(CategoryDto category);
   Optional <Set<Product>> findProductByNameOrReference(String name,String reference);


}
