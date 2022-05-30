package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.PaymentDto;
import com.beapsmarket.webapp.model.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface PaymentMapper {

    Payment toEntity(PaymentDto paymentDto);

    PaymentDto toDto(Payment payment);

    void copy(PaymentDto paymentDto, @MappingTarget Payment payment);
}
