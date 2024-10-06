package com.hsgumussoy.basket.basket.impl.basketproduct;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
    BasketProduct findByBasket_IdAndProductId(Long basketId, Long productId);
}
