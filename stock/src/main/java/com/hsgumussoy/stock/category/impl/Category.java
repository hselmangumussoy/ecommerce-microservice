package com.hsgumussoy.stock.category.impl;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= Category.TABLE)
@Entity
@Builder
public class Category {
    public static final String TABLE = "category";
    public static final String COL_NAME = "name";
    public static final String COL_DESCRIPTION = "description";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = COL_NAME)
    private String name;
    @Column(name = COL_DESCRIPTION)
    private String description;
}
