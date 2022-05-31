package com.beapsmarket.webapp.service;


import com.beapsmarket.webapp.mapper.ProductMapper;
import com.beapsmarket.webapp.model.dto.CategoryDto;
import com.beapsmarket.webapp.model.dto.ProductDto;
import com.beapsmarket.webapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProduct{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Override
    public int saveProduct(ProductDto productDto) {
        productRepository.save(productMapper.toEntity(productDto));
        return 0;
    }

    @Override
    public int deleteProduct(String reference) {
        productRepository.deleteById(productRepository.findProductByReference(reference).get().getId());
        return 1;
    }

    @Override
    public Set<ProductDto> searchProductByCategory(CategoryDto categoryDto) {
        return productRepository.findProductByCategory(categoryDto).get().stream().map(productMapper::toDto).collect(Collectors.toSet()) ;
    }

    @Override
    public ProductDto searchProductByReference(String reference) {
        return productMapper.toDto(productRepository.findProductByReference(reference).get());
    }

    @Override
    public Set<ProductDto> searchProductByKeyword(String keyword) {
        return productRepository.findProductByNameOrReference(keyword, keyword).get().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ProductDto> ListProduct() {
        return productRepository.findAll().stream().map(product -> productMapper.toDto(product)).collect(Collectors.toSet());
    }
    }


