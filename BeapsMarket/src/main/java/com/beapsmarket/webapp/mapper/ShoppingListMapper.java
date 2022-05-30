package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.model.entities.ShoppingList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ShoppingListMapper {

    ShoppingList toEntity(ShoppingListDto shoppingListDto);

    ShoppingListDto toDto(ShoppingList shoppingList);

    void copy(ShoppingListDto shoppingListDto, @MappingTarget ShoppingList shoppingList);
}
