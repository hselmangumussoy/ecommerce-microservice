package com.hsgumussoy.stock.product.impl;

import com.hsgumussoy.stock.product.api.ProductDto;
import com.hsgumussoy.stock.product.api.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    public ProductDto save(ProductDto dto) {
        return ProductMapper.toDto(repository.save(ProductMapper.toEntity(new Product(), dto)));
    }

    @Override
    public ProductDto get(String id) {
        return ProductMapper.toDto(repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException( "Product not found"+ id)));

    }

    @Override
    public List<ProductDto> getAll() {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ProductDto update(String id, ProductDto dto) {
        return null;
    }
}
