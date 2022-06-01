package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.model.entities.ShoppingList;

import java.util.List;

public interface IShoppingList {
    int deleteShoppingList(String reference);
    List<ShoppingListDto> ListShoppingList();
    ShoppingListDto searchShoppingListByReference (String reference);
    ShoppingListDto searchShoppingListByName(String name);
}
