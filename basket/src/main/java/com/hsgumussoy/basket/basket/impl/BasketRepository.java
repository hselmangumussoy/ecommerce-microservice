package com.hsgumussoy.basket.basket.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Basket findBasketByUserIdAndStatusEquals(Long userId, int basketStatusNone);
}
