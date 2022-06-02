package com.beapsmarket.webapp.service;


import com.beapsmarket.webapp.model.dto.ProductDto;

import java.util.Set;

public interface IProduct {

  int saveProduct(ProductDto productDto);

  Set<ProductDto> searchAllProduct();

  ProductDto searchProductByReference(String reference);

  Set<ProductDto> searchProductByKeyword(String keyword);

  int updateProduct(ProductDto productDto);

  int deleteProduct(String reference);
}
