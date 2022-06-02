package com.beapsmarket.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeliveryDto {
    private String reference;

    private Boolean state = false;

    private UserDto userDto;
}
