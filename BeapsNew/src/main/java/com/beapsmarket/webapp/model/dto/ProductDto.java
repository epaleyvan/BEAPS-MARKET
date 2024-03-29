package com.beapsmarket.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private String reference;

    private String name;

    private Double unitprice;

    private String description;

    private Integer quantityList;

    private CategoryDto categoryDto;


    private Set<ImageDto> imageDtos = new TreeSet<ImageDto>();

    private Set<ShoppingListDto> shoppingListDtos = new HashSet<ShoppingListDto>();
}
