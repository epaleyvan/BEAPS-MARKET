package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.UserDto;
import com.beapsmarket.webapp.model.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    void copy(UserDto userDto, @MappingTarget User user);
}
