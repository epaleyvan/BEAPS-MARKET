package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.model.entities.ShoppingList;

import java.util.List;
import java.util.Set;

public interface IShoppingList {
    int deleteShoppingList(String reference);
    Set<ShoppingListDto> ListShoppingList();
    ShoppingListDto searchShoppingListByReference (String reference);
    ShoppingListDto searchShoppingListByName(String name);
     int updateShoppingList(ShoppingListDto shoppingListDto);
     int saveShoppingList(ShoppingListDto shoppingListDto);
}
