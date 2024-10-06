package com.hsgumussoy.stock.product.api;

import com.hsgumussoy.stock.product.web.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto dto);

    ProductDto get(String id);

    List<ProductDto> getAll();

    void delete(String id);

    ProductDto update(String id, ProductDto dto);
}
