package com.hsgumussoy.payment.payment.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String orderNumber;
    private String cardNo;
    private String cardHolderName;
    private String cardExpiryDate;
    private Double price;
    private Double discountPrice;
    private Double originalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
    