package com.beapsmarket.webapp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {

	private String name;
	private Set<ProductDto> productDtos;
}