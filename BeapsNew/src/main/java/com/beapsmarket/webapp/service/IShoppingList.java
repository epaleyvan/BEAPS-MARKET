package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.ShoppingListDto;

public interface IShoppingList {

    int saveShoppingList(ShoppingListDto shoppingListDto);

    ShoppingListDto searchShoppingListByReference(String reference);

    int updateShoppingList(ShoppingListDto shoppingListDto);

    int deleteShoppingList(String reference);
}
