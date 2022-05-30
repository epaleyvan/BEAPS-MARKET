package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.ProductDto;
import com.beapsmarket.webapp.model.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {

    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);

    void copy(ProductDto productDto, @MappingTarget Product product);
}
