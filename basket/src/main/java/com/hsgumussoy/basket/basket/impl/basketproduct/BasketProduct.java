package com.hsgumussoy.basket.basket.impl.basketproduct;

import com.hsgumussoy.basket.basket.impl.Basket;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = BasketProduct.TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketProduct {
    public static final String TABLE = "basket_product";
    public static final String COUNT = "count";
    public static final String PRODUCT_ID = "product_id";
//    public static final String BASKET_ID = "basket_id";
    public static final String TOTAL_AMOUNT = "total_amount";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = COUNT)
    private double count;

    @Column(name = PRODUCT_ID)
    private Long productId;

//    @Column(name = BASKET_ID)
//    private Long basketId;

    @Column(name = TOTAL_AMOUNT)
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "basket_id", referencedColumnName = "id")
    private Basket basket;
}
