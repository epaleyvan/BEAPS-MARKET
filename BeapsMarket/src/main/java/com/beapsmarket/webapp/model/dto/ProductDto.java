package com.beapsmarket.webapp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

	private String reference;
	private String name;
	private int unitPrice;
	private String description;
	private int quantityList;
	private CategoryDto categoryDto;
	private Set<ShoppingListDto> shoppingListDtos;
	private Set<PictureDto> pictureDtos;

}