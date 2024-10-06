package com.hsgumussoy.stock.category.impl;

import com.hsgumussoy.stock.category.api.CategoryDto;

public class CategoryMapper {
    public static Category toEntity(Category category, CategoryDto dto) {
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
