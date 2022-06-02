package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.mapper.ShoppingListMapper;
import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.model.entities.ShoppingList;
import com.beapsmarket.webapp.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListServiceImpl implements IShoppingList{
    @Autowired
    ShoppingListMapper shoppingListMapper;

    @Autowired
    ShoppingListRepository shoppingListRepository;


    @Override
    public int saveShoppingList(ShoppingListDto shoppingListDto) {
        if(shoppingListRepository.existsByReference(shoppingListDto.getReference())){
            return shoppingListRepository.save(shoppingListMapper.toEntity(shoppingListDto)).getId();
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
    public int updateShoppingList(ShoppingListDto shoppingListDto) {
        try{
            ShoppingList shoppingList = shoppingListRepository.findByReference(shoppingListDto.getReference());
            shoppingListMapper.copy(shoppingListDto, shoppingList);
            return shoppingListRepository.save(shoppingList).getId();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

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

}
