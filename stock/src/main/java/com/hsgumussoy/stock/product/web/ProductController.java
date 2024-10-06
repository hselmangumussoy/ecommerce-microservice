package com.hsgumussoy.stock.product.web;

import com.hsgumussoy.stock.product.api.ProductMapper;
import com.hsgumussoy.stock.product.api.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
   /*@GetMapping("/test")
    public String test(){
        return "product test";
    }*/
   @PostMapping
   public ProductResponse save(@RequestBody ProductRequest request) {
       return ProductMapper.toResponse(service.save(ProductMapper.toDto(request)));
   }


    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable(name = "id") String id) {
        return ProductMapper.toResponse(service.get(id));
    }


    @GetMapping
    public List<ProductResponse> getAll() {
        return ProductMapper.toResponses(service.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable(name = "id") String id, @RequestBody ProductRequest request) {
        return ProductMapper.toResponse(service.update(id, ProductMapper.toDto(request)));
    }
}
