package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.AddressDto;
import com.beapsmarket.webapp.model.entities.Address;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface AddressMapper {

    @Mapping(source = "addressDto.userDto", target = "user")
    Address toEntity(AddressDto addressDto);

    @Mapping(source = "address.user", target = "userDto")
    AddressDto toDto(Address address);

    @Mapping(source = "addressDto.userDto", target = "user")
    void copy(AddressDto addressDto, @MappingTarget Address address);
}
