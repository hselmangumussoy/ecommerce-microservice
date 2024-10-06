package com.hsgumussoy.basket.basket.api;


import com.hsgumussoy.basket.basket.impl.basketproduct.BasketProduct;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketDto {
    private Long id;
    private int status;
    private double totalPrice;
    private double count;

    private Long userId;
    private List<BasketProduct> basketProductList;
}
