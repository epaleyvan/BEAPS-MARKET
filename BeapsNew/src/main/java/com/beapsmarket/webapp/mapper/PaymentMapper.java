package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.PaymentDto;
import com.beapsmarket.webapp.model.entities.Payment;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface PaymentMapper {

    @Mapping(source = "paymentDto.userDto", target = "user")
    Payment toEntity(PaymentDto paymentDto);

    @Mapping(source = "payment.user", target = "userDto")
    PaymentDto toDto(Payment payment);

    @Mapping(source = "paymentDto.userDto", target = "user")
    void copy(PaymentDto paymentDto, @MappingTarget Payment payment);
}
