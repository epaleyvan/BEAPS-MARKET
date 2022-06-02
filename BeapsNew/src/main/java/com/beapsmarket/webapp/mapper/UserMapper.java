package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.UserDto;
import com.beapsmarket.webapp.model.entities.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userDto.addressDtos", target = "addresses")
    @Mapping(source = "userDto.deliveryDtos", target = "deliveries")
    @Mapping(source = "userDto.paymentDtos", target = "payments")
    @Mapping(source = "userDto.shoppingListDtos", target = "shoppingLists")
    User toEntity(UserDto userDto);

    @Mapping(source = "user.addresses", target = "addressDtos" )
    @Mapping(source = "user.deliveries", target = "deliveryDtos")
    @Mapping(source = "user.payments", target = "paymentDtos")
    @Mapping(source = "user.shoppingLists", target = "shoppingListDtos")
    UserDto toDto(User user);

    @Mapping(source = "userDto.addressDtos", target = "addresses")
    @Mapping(source = "userDto.deliveryDtos", target = "deliveries")
    @Mapping(source = "userDto.paymentDtos", target = "payments")
    @Mapping(source = "userDto.shoppingListDtos", target = "shoppingLists")
    void copy(UserDto userDto, @MappingTarget User user);
}
