package com.beapsmarket.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
    private String reference;

    private String name;

    private Set<ProductDto> productDtos = new HashSet<ProductDto>();
}
