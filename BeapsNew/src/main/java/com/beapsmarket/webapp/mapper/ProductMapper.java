package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.ProductDto;
import com.beapsmarket.webapp.model.entities.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {

    @Mapping(source = "productDto.imageDtos", target = "images")
    @Mapping(source = "productDto.shoppingListDtos", target = "shoppingLists")
    @Mapping(source = "productDto.categoryDto", target = "category")
    Product toEntity(ProductDto productDto);

    @Mapping(source = "product.images", target = "imageDtos")
    @Mapping(source = "product.shoppingLists", target = "shoppingListDtos")
    @Mapping(source = "product.category", target = "categoryDto")
    ProductDto toDto(Product product);

    @Mapping(source = "productDto.imageDtos", target = "images")
    @Mapping(source = "productDto.shoppingListDtos", target = "shoppingLists")
    @Mapping(source = "productDto.categoryDto", target = "category")
    void copy(ProductDto productDto, @MappingTarget Product product);
}
