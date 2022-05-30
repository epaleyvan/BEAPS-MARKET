package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.AddressDto;
import com.beapsmarket.webapp.model.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface AddressMapper {

    Address toEntity(AddressDto addressDto);

    AddressDto toDto(Address address);

    void copy(AddressDto addressDto, @MappingTarget Address address);
}
