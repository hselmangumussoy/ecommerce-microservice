package com.hsgumussoy.basket.basket.api;

import com.hsgumussoy.basket.basket.impl.basketproduct.BasketProductServiceImpl;
import com.hsgumussoy.basket.basket.web.AddBasketRequest;
import com.hsgumussoy.basket.basket.web.BasketResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BasketMapper {
    private static BasketProductServiceImpl basketProductService ;

    public static AddBasketDto toDto(AddBasketRequest request) {
        return AddBasketDto.builder()
                .productId(request.getProductId())
                .userId(request.getUserId())
                .count(request.getCount())
                .build();
    }

    public static BasketResponse toResponse(BasketDto dto) {
        return BasketResponse.builder()
                .basketProductList(dto.getBasketProductList())
                .status(dto.getStatus())
                .id(dto.getId())
                .totalPrice(dto.getTotalPrice())
                .userId(dto.getUserId())
                .count(dto.getCount())
                .build();
    }

   /* public static List<BasketResponse> mapDtosToResponses(List<BasketDto> dtos) {
        return dtos.stream()
                .map(BasketMapper::toResponse)
                .collect(Collectors.toList());
    }*/
}
