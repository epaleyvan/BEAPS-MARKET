package com.beapsmarket.webapp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String name;

    private String surname;

    private String gender;

    private Integer phone;

    private String type;

    private String email;

    private String username;

    private String password;


    private Set<AddressDto> addressDtos = new HashSet<AddressDto>();

    private Set<DeliveryDto> deliveryDtos = new HashSet<DeliveryDto>();

    private Set<PaymentDto> paymentDtos = new HashSet<PaymentDto>();
}
