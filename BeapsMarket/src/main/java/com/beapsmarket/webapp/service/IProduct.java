package com.beapsmarket.webapp.service;


import com.beapsmarket.webapp.model.dto.ProductDto;


import java.util.Set;

public interface IProduct {
  int saveProduct(ProductDto productDto);
  ProductDto searchProductByReference(String reference);
  Set<ProductDto> searchProductByKeyword(String keyword);
  Set<ProductDto> searchAllProduct();
 int deleteProduct(String reference);
}
