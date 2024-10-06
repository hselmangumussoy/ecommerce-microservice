package com.hsgumussoy.basket.basket.impl.basketproduct;

import com.hsgumussoy.basket.basket.api.BasketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class BasketProductServiceImpl{
    private final BasketProductRepository repository;

    public BasketProduct findByBasket_IdAndProductId(Long basketId, Long productId) {
        return repository.findByBasket_IdAndProductId(basketId,productId);
    }

//        public void delete(String productId) {
//            repository.deleteById(Long.valueOf(productId));
//        }
}

