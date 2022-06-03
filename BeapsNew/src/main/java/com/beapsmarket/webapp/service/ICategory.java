package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.CategoryDto;

import java.util.Set;

public interface ICategory {

    int saveCategory(CategoryDto categoryDto);

    CategoryDto findCategoryByReference(String reference);

    Set<CategoryDto> findAllCategory();
}
