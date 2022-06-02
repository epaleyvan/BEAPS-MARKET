package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.model.entities.ShoppingList;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ShoppingListMapper {

    @Mapping(source = "shoppingListDto.productDtos", target = "products")
    @Mapping(source = "shoppingListDto.paymentDto", target = "payment")
    @Mapping(source = "shoppingListDto.deliveryDto", target = "delivery")
    @Mapping(source = "shoppingListDto.userDto", target = "user")
    ShoppingList toEntity(ShoppingListDto shoppingListDto);

    @Mapping(source = "shoppingList.products", target = "productDtos")
    @Mapping(source = "shoppingList.payment", target = "paymentDto")
    @Mapping(source = "shoppingList.delivery", target = "deliveryDto")
    @Mapping(source = "shoppingList.user", target = "userDto")
    ShoppingListDto toDto(ShoppingList shoppingList);

    @Mapping(source = "shoppingListDto.productDtos", target = "products")
    @Mapping(source = "shoppingListDto.paymentDto", target = "payment")
    @Mapping(source = "shoppingListDto.deliveryDto", target = "delivery")
    @Mapping(source = "shoppingListDto.userDto", target = "user")
    void copy(ShoppingListDto shoppingListDto, @MappingTarget ShoppingList shoppingList);
}
