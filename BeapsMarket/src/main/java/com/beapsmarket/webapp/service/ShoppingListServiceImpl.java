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
        try{
            shoppingListRepository.delete(shoppingListRepository.findByReference(reference));
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public int saveShoppingList(ShoppingListDto shoppingListDto) {
        if(shoppingListRepository.existsByReference(shoppingListDto.getReference())){
            shoppingListRepository.save(shoppingListMapper.toEntity(shoppingListDto));
            return 0;
        }
        return -1;
    }

    @Override
    public ShoppingListDto searchShoppingListByReference(String reference) {
        try {
            return shoppingListMapper.toDto(shoppingListRepository.findByReference(reference));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ShoppingListDto searchShoppingListByName(String name) {
        try{
            return shoppingListMapper.toDto(shoppingListRepository.findByNameIgnoreCase(name));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
