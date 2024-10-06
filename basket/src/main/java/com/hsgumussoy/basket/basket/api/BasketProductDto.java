package com.hsgumussoy.basket.basket.api;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketProductDto {
    private Long id;
    private double count;
    private Long productId;
    private double totalAmount;
    private Long basketId;

}
