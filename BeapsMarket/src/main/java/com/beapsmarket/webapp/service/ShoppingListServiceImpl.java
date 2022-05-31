package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.mapper.ShoppingListMapper;
import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.model.entities.ShoppingList;
import com.beapsmarket.webapp.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingListServiceImpl implements IShoppingList{
    @Autowired
    ShoppingListMapper shoppingListMapper;
    @Autowired
    ShoppingListRepository shoppingListRepository;
    @Override
    public int deleteShoppingList(String reference) {
        shoppingListRepository.delete(shoppingListRepository.findByReference(reference));
        return 1;
    }

    @Override
    public List<ShoppingListDto> ListShoppingList() {
        return shoppingListRepository.findAll().stream().map(shoppingList -> shoppingListMapper.toDto(shoppingList)).collect(Collectors.toList());
    }

    @Override
    public ShoppingListDto searchShoppingListByReference(String reference) {
        return shoppingListMapper.toDto(shoppingListRepository.findByReference(reference));
    }

    @Override
    public ShoppingListDto searchShoppingListByName(String name) {
        return shoppingListMapper.toDto(shoppingListRepository.findByNameIgnoreCase(name));
    }
}
