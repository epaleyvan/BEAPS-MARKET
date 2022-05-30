package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.CategoryDto;
import com.beapsmarket.webapp.model.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface CategoryMapper {

    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    void copy(CategoryDto categoryDto, @MappingTarget Category category);
}
