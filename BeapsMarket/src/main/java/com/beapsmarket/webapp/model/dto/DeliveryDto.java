package com.beapsmarket.webapp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeliveryDto {

	private boolean state;
	private Set<ShoppingListDto> shoppingListsDtos;
	private UserDto userDto;

}