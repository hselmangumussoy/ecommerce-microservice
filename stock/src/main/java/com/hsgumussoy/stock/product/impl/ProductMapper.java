package com.hsgumussoy.stock.product.impl;

import com.hsgumussoy.stock.category.api.CategoryDto;
import com.hsgumussoy.stock.product.api.ProductDto;

public class ProductMapper {
    public static Product toEntity(Product product, ProductDto dto) {
        product.setDescription(dto.getDescription());
        product.setCategoryId(dto.getCategory().getId());
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());
        return product;
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(CategoryDto.builder().id(product.getCategoryId()).build())
                .price(product.getPrice())
                .build();
    }
}
