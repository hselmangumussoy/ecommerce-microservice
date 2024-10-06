package com.hsgumussoy.stock.product.api;

import com.hsgumussoy.stock.category.api.CategoryDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private CategoryDto category;
}
