package com.beapsmarket.webapp.model.dto;


import com.beapsmarket.webapp.model.entities.Gender;
import com.beapsmarket.webapp.model.entities.TypeOfAccount;
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
	private Gender gender;
	private Set<AddressDto> addressesDtos = new HashSet<>();
	private int phone;
	private TypeOfAccount type;
	private String email;
	private String username;
	private String password;
	private Set<ShoppingListDto> shoppingListDtos = new HashSet<>();
	private Set<PaymentDto> paymentDtos = new HashSet<>();
	private Set<DeliveryDto> deliveryDtos = new HashSet<>();


}