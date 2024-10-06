package com.hsgumussoy.stock.product.api;

import com.hsgumussoy.stock.category.api.CategoryDto;
import com.hsgumussoy.stock.product.web.ProductRequest;
import com.hsgumussoy.stock.product.web.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductDto toDto(ProductRequest request) {
        return ProductDto.builder()
                .category(CategoryDto.builder().id(request.getCategoryId()).build())
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .build();
    }

    public static ProductResponse toResponse(ProductDto dto) {
        return ProductResponse.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .name(dto.getName())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .build();
    }

    public static List<ProductResponse> toResponses(List<ProductDto> dtos) {
        return dtos.stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }
}
