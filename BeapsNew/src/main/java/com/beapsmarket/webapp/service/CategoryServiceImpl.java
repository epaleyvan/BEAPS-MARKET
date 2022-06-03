package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.mapper.CategoryMapper;
import com.beapsmarket.webapp.model.dto.CategoryDto;
import com.beapsmarket.webapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategory{

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int saveCategory(CategoryDto categoryDto) {
        return categoryRepository.save(categoryMapper.toEntity(categoryDto)).getId();
    }

    @Override
    public CategoryDto findCategoryByReference(String reference) {
        return categoryMapper.toDto(categoryRepository.findByReference(reference));
    }

    @Override
    public Set<CategoryDto> findAllCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toSet());
    }
}
