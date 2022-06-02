package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.DeliveryDto;
import com.beapsmarket.webapp.model.entities.Delivery;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface DeliveryMapper {
    @Mapping(source = "deliveryDto.userDto", target = "user")
    Delivery toEntity(DeliveryDto deliveryDto);

    @Mapping(source = "delivery.user", target = "userDto")
    DeliveryDto toDto(Delivery delivery);

    @Mapping(source = "deliveryDto.userDto", target = "user")
    void copy(DeliveryDto deliveryDto, @MappingTarget Delivery delivery);
}
