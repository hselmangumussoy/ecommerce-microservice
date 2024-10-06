package com.hsgumussoy.stock.category.api;

import com.hsgumussoy.stock.category.web.CategoryRequest;
import com.hsgumussoy.stock.category.web.CategoryResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryDto toDto(CategoryRequest request) {
        return CategoryDto.builder()
                .name(request.getName())
                .description(request.getDescrpition())
                .build();
    }

    public static CategoryResponse toResponse(CategoryDto dto) {
        return CategoryResponse.builder()
                .id(dto.getId())
                .descrpition(dto.getDescription())
                .name(dto.getName())
                .build();
    }

    public static List<CategoryResponse> toResponses(List<CategoryDto> dtos) {
        return dtos.stream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList());
    }
}
