package com.hsgumussoy.stock.category.web;

import com.hsgumussoy.stock.category.api.CategoryMapper;
import com.hsgumussoy.stock.category.api.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;
    @GetMapping("/test")
    public String test(){
        return  "Category testidir.";
    }
    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest request) {
        return CategoryMapper.toResponse(service.save(CategoryMapper.toDto(request)));
    }

    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable String id) {
        return CategoryMapper.toResponse(service.get(id));
    }

    @GetMapping
    public List<CategoryResponse> getAll(){
        return CategoryMapper.toResponses(service.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable(name = "id") String id, @RequestBody CategoryRequest request) {
        return CategoryMapper.toResponse(service.update(id, CategoryMapper.toDto(request)));
    }
}
