package com.hsgumussoy.basket.basket.web;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddBasketRequest {
    private Long userId;
    private Long productId;
    private int count;
}
