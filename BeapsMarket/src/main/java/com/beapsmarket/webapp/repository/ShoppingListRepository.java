package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    ShoppingList findByNameIgnoreCase(String string);
    ShoppingList deleteByReference(String reference);
    ShoppingList findByReference(String string);
    Optional<ShoppingList> findByNameOrReference(String name);

    boolean existsByReference(String string);
}
