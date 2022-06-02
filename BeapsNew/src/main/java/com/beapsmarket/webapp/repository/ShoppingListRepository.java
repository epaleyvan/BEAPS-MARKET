package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    ShoppingList findByReference(String string);

    void deleteByReference(String reference);

    boolean existsByReference(String string);
}
