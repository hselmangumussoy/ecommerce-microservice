package com.hsgumussoy.basket.basket.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddBasketDto {
    private final Long productId;
    private final Long userId;
    private final int count;
}
