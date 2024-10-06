package com.hsgumussoy.stock.category.api;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto dto);
    void delete(String id);
    CategoryDto update(String id, CategoryDto dto);
    List<CategoryDto> getAll();
    CategoryDto get(String id);
}
