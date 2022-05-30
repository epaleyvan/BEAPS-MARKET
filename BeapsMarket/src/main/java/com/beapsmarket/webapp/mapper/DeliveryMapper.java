package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.DeliveryDto;
import com.beapsmarket.webapp.model.entities.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface DeliveryMapper {

    Delivery toEntity(DeliveryDto deliveryDto);

    DeliveryDto toDto(Delivery delivery);

    void copy(DeliveryDto deliveryDto, @MappingTarget Delivery delivery);
}
