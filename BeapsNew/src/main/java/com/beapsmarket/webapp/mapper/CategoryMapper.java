package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.CategoryDto;
import com.beapsmarket.webapp.model.entities.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface CategoryMapper {

    @Mapping(source = "categoryDto.productDtos", target = "products")
    Category toEntity(CategoryDto categoryDto);

    @Mapping(source = "category.products", target = "productDtos")
    CategoryDto toDto(Category category);

    @Mapping(source = "categoryDto.productDtos", target = "products")
    void copy(CategoryDto categoryDto, @MappingTarget Category category);
}
