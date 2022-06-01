package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.CategoryDto;
import com.beapsmarket.webapp.model.dto.ProductDto;

import java.util.List;
import java.util.Set;

public interface IProduct {
 int saveProduct(ProductDto productDto);
 int deleteProduct(String numero);
 Set<ProductDto> searchProductByCategory(CategoryDto categoryDto);
 ProductDto searchProductByReference(String reference);
 Set<ProductDto>searchProductByKeyword(String keyword);
 Set<ProductDto>ListProduct();
}
