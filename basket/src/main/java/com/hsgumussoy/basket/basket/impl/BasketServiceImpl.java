package com.hsgumussoy.basket.basket.impl;

import com.hsgumussoy.basket.basket.api.AddBasketDto;
import com.hsgumussoy.basket.basket.api.BasketDto;
import com.hsgumussoy.basket.basket.api.BasketService;
import com.hsgumussoy.basket.basket.api.ProductDto;
import com.hsgumussoy.basket.basket.api.UserDto;
import com.hsgumussoy.basket.basket.impl.basketproduct.BasketProduct;
import com.hsgumussoy.basket.basket.impl.basketproduct.BasketProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository repository;
    private final BasketProductServiceImpl basketProductService;
    private static final int BASKET_STATUS_NONE = 0;
    private static final int BASKET_STATUS_SALED = 1;
    private static final String USER_URL = "http://localhost:8081/users/";
    private static final String PRODUCT_URL = "http://localhost:8085/products/";
    RestTemplate restTemplate = new RestTemplate();
    @Transactional
    public BasketDto addProductToBasket(AddBasketDto dto){
        UserDto user = getUserById(String.valueOf(dto.getUserId())).orElseThrow(()-> new RuntimeException("User not found"));
        Basket basket = repository.findBasketByUserIdAndStatusEquals(user.getId(),BASKET_STATUS_NONE);
        if (basket != null){
            return basketExistsAddNewProduct(basket, dto);
        }else {
            return basketDoesntExistAddNewProduct(dto,user);
        }
    }
    @Transactional
    public BasketDto basketExistsAddNewProduct(Basket basket, AddBasketDto dto) {
        List<BasketProduct> basketProductList = basket.getBasketProductList();
        BasketProduct basketProduct = basketProductService.findByBasket_IdAndProductId(basket.getId(), dto.getProductId());
        ProductDto product = getProductById(String.valueOf(dto.getProductId())).orElseThrow(()-> new RuntimeException("Product not found"));

        if (basketProduct ==null){
            BasketProduct newBasketProduct = createBasketProduct(product, basket, new BasketProduct(), dto);
            basketProductList.add(newBasketProduct);

        }else {
            basketProduct.setProductId(product.getId());
            basketProduct.setCount(basketProduct.getCount() + dto.getCount());
            basketProduct.setTotalAmount(basketProduct.getCount() * product.getPrice());
            basketProduct.setBasket(basket);
            basketProductList.add(basketProduct);
        }
        basket.setBasketProductList(basketProductList);
        basket.setTotalPrice(calculateTotalPrice(basketProductList));
        repository.save(basket);

        return BasketMapper.toDto(basket);

    }

    @Transactional
    public BasketDto basketDoesntExistAddNewProduct(AddBasketDto dto, UserDto user) {
        Basket basket = new Basket();
        basket.setStatus(BASKET_STATUS_NONE);
        basket.setUserId(user.getId());
        basket.setCount(dto.getCount());

        ProductDto product = getProductById(String.valueOf(dto.getProductId()))
                .orElseThrow(() -> new RuntimeException("Product not found"));

        BasketProduct newBasketProduct = createBasketProduct(product, basket, new BasketProduct(), dto);
        List<BasketProduct> basketProductList = new ArrayList<>();
        basketProductList.add(newBasketProduct);

        basket.setBasketProductList(basketProductList);
        basket.setTotalPrice(calculateTotalPrice(basketProductList));

        repository.save(basket);
        return BasketMapper.toDto(basket);
    }



    private BasketProduct createBasketProduct(ProductDto product, Basket basket ,BasketProduct newBasketProduct, AddBasketDto dto) {
        newBasketProduct.setProductId(product.getId());
        newBasketProduct.setCount(dto.getCount());
        newBasketProduct.setTotalAmount(dto.getCount()*product.getPrice());
        newBasketProduct.setBasket(basket);
        return newBasketProduct;
    }

    public Optional<UserDto> getUserById(String userId){
        UserDto existingUser = restTemplate.getForObject(USER_URL+ userId,UserDto.class);
        return Optional.of(existingUser);
    }
    public Optional<ProductDto> getProductById(String productId){
        ProductDto existingProduct = restTemplate.getForObject(PRODUCT_URL+ productId,ProductDto.class);
        return Optional.of(existingProduct);
    }


//    private double calculateBasketTotalPrice(List<BasketProduct> basketProductList) {
//        double totalPrice = 0;
//        for (BasketProduct basketProduct : basketProductList) {
//            totalPrice += basketProduct.getTotalAmount();
//        }
//        return totalPrice;
//    }
private double calculateTotalPrice(List<BasketProduct> basketProductList) {
    return basketProductList.stream()
            .mapToDouble(BasketProduct::getTotalAmount)
            .sum();
}



//    @Override
//    public BasketDto deleteProduct(String basketId, Long productId) {
//        Basket basket = repository.findById(Long.valueOf(basketId)).orElseThrow();
//        List<BasketProduct> basketProducts = basket.getBasketProducts();
//        BasketProduct basketProduct = basketProductService.findByBasketIdAndProductId(basketId, productId);
//        if (basketProduct != null) {
//            basketProducts.remove(basketProduct);
//            basketProductService.delete(basketProduct.getBasketProductId().toString());
//            basket.setBasketProducts(basketProducts);
//            basket.setTotalPrice(calculateBasketTotalPrice(basketProducts));
//            repository.save(basket);
//            return toDto(basket);
//        } else {
//            throw new RuntimeException("BasketProduct not found");
//        }
//    }

//    @Override
//    public BasketDto updateStatus(String basketId) {
//        Basket basket = repository.findById(UUID.fromString(basketId)).orElseThrow();
//
//        if (basket.getStatus() != BasketStatus.SALED.getValue()) {
//            basket.setStatus(BasketStatus.SALED.getValue());
//        }else{
//            basket.setStatus(BasketStatus.NONE.getValue());
//        }
//        basketRepository.save(basket);
//        return toDto(basket);
//    }


//    @Override
//    public BasketDto get(Long basketId) {
//        Basket basket = repository.findById(basketId).orElseThrow();
//        return toDto(basket);
//    }


//    private BasketDto toDto(Basket basket) {
//        List<BasketProductDto> basketProductDtos = new ArrayList<>();
//        for (BasketProduct basketProduct : basket.getBasketProducts()) {
//            ProductDto existingProduct = restTemplate.getForObject(PRODUCT_URL + basket.getBasketProducts().get().getProductId()),User.class);
//            basketProductDtos.add(
//                    BasketProductDto.builder()
//                            .basketProductId(basketProduct.getBasketProductId())
//                            .count(basketProduct.getCount())
//
//                            .build()
//            );
//        }
//        return BasketDto.builder()
//                .basketId(basket.getBasketId())
//                .status(basket.getStatus())
//                .totalPrice(basket.getTotalPrice())
//                .user(UserDto.builder().userId().build())
//                .basketProducts(basketProductDtos)
//                .build();
//    }
}