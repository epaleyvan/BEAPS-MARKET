package com.beapsmarket.webapp.service;


import com.beapsmarket.webapp.mapper.ProductMapper;
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
        if (productRepository.existsByReference(productDto.getReference())){
            return productRepository.save(productMapper.toEntity(productDto)).getId().intValue();
        }
        return -1;
    }

    @Override
    public int deleteProduct(String reference) {
        try{
            productRepository.deleteById(productRepository.findByReference(reference).getId());
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public ProductDto searchProductByReference(String reference) {
        try{
            return productMapper.toDto(productRepository.findByReference(reference));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Set<ProductDto> searchProductByKeyword(String keyword) {
        try{
            return productRepository.findByName(keyword).get().stream()
                    .map(productMapper::toDto)
                    .collect(Collectors.toSet());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Set<ProductDto> searchAllProduct() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toSet());
    }

}


