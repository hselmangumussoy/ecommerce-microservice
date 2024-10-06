package com.hsgumussoy.basket.basket.web;

import com.hsgumussoy.basket.basket.api.BasketMapper;
import com.hsgumussoy.basket.basket.api.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;

    @PostMapping
    public BasketResponse addProductToBasket(@RequestBody AddBasketRequest request){
        return BasketMapper.toResponse(service.addProductToBasket(BasketMapper.toDto(request)));
    }

//    @GetMapping("/{id}")
//    public BasketResponse get(@PathVariable(name = "id") Long id) {
//        return BasketMapper.toResponse(service.get(id));
//    }
//
//   /* @GetMapping
//    public List<BasketResponse> getAll(){
//        return BasketMapper.mapDtosToResponses(service.getAll());
//    }*/
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable(name = "id") Long id) {
//        service.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public BasketResponse update(@PathVariable(name = "id") String id, @RequestBody AddBasketRequest request) {
//        return BasketMapper.toResponse(service.update(id, BasketMapper.toDto(request)));
//    }
}