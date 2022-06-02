package com.beapsmarket.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingListDto {
    private String reference;

    private PaymentDto paymentDto;

    private DeliveryDto deliveryDto;

    private UserDto userDto;

    private Set<ProductDto> productDtos = new HashSet<ProductDto>();
}
