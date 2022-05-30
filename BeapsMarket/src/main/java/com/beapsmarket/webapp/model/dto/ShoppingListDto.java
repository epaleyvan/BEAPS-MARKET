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
    private Set<ProductDto> productDtos = new HashSet<>();
    private PaymentDto paymentDto;
    private UserDto userDto;
    private DeliveryDto deliveryDto;

}