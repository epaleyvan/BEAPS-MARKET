package com.beapsmarket.webapp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDto {

	private String reference;
	private double totalPrice;
	private ShoppingListDto shoppingListDto;
	private UserDto userDto;

}