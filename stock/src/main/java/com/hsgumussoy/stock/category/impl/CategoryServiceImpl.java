package com.hsgumussoy.stock.category.impl;

import com.hsgumussoy.stock.category.api.CategoryDto;
import com.hsgumussoy.stock.category.api.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    @Override
    public CategoryDto save(CategoryDto dto) {
        return CategoryMapper.toDto(repository.save(CategoryMapper.toEntity(new Category(), dto)));
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public CategoryDto update(String id, CategoryDto dto) {
        return null;
    }

    @Override
    public List<CategoryDto> getAll() {
        return null;
    }

    @Override
    public CategoryDto get(String id) {
        return null;
    }
}
