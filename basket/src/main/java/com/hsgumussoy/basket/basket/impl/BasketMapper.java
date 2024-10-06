package com.hsgumussoy.basket.basket.impl;

import com.hsgumussoy.basket.basket.api.BasketDto;

import java.util.stream.Collectors;

public class BasketMapper {

//    public static Basket toEntity(Basket basket, BasketDto dto, UserDto user) {
//        basket.setUserId(user.getUserId());
//        basket.setCount(dto.getCount());
//        basket.setTotalPrice(dto.getTotalPrice());//düzenlenme gerekiyor
//        basket.setStatus(dto.getStatus());//düzenlenme gerekiyor
//        return basket;
//    }

    public static BasketDto toDto(Basket basket) {
        return BasketDto.builder()
                .id(basket.getId())
                .totalPrice(basket.getTotalPrice())
                .count(basket.getCount())
                .basketProductList(basket.getBasketProductList())
                .userId(basket.getUserId())
                .status(basket.getStatus())
                .build();
    }
}
