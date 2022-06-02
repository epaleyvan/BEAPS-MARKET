package com.beapsmarket.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageDto {
    private String reference;

    private String name;

    private String url;

    private ProductDto productDto;
}
