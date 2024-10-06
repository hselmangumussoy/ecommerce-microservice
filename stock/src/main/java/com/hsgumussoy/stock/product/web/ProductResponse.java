package com.hsgumussoy.stock.product.web;

import com.hsgumussoy.stock.category.api.CategoryDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private double price;
    private CategoryDto category;
}
