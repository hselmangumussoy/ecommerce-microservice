package com.hsgumussoy.stock.product.impl;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Product.TABLE)
@Builder
public class Product {
    public static final String TABLE = "product";
    public static final String COL_NAME = "name";
    public static final String COL_CATEGORY_ID = "category_id";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_PRICE = "price";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = COL_CATEGORY_ID)
    private Long categoryId;
    @Column(name = COL_NAME)
    private String name;
    @Column(name = COL_DESCRIPTION)
    private String description;
    @Column(name = COL_PRICE)
    private double price;
}
