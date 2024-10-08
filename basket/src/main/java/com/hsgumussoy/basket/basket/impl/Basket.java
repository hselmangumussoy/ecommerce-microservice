package com.hsgumussoy.basket.basket.impl;

import com.hsgumussoy.basket.basket.impl.basketproduct.BasketProduct;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = Basket.TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Basket {
    public static final String TABLE = "basket";
    public static final String USER_ID = "user_id";
    public static final String STATUS = "status";
    public static final String TOTAL_PRICE = "total_price";
    public static final String COUNT = "count";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = STATUS)
    private int status;

    @Column(name = USER_ID)
    private Long userId;

    @Column(name = TOTAL_PRICE)
    private double totalPrice;

    @Column(name = COUNT)
    private double count;

    @OneToMany(mappedBy = "basket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @SequenceGenerator(name = "basket_product_seq", sequenceName = "basket_product_seq", allocationSize = 1)
    private List<BasketProduct> basketProductList;

}
