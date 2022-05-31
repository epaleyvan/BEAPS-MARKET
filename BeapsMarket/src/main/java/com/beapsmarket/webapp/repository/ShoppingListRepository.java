package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    ShoppingList findByNameIgnoreCase(String string);
    ShoppingList findByReference(String string);
    boolean existsByReference(String string);
}
