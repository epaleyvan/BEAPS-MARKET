package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.model.entities.ShoppingList;

import java.util.List;

public interface IShoppingList {
    int saveShoppingList(ShoppingListDto shoppingListDto);
    ShoppingListDto searchShoppingListByReference (String reference);
    ShoppingListDto searchShoppingListByName(String name);
    int deleteShoppingList(String reference);
}
