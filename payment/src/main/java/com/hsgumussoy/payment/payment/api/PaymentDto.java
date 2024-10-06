package com.hsgumussoy.payment.payment.api;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PaymentDto {
    private String id;
    private String userId;
    private String orderNumber;
    private String cardNo;
    private String cardHolderName;
    private String cardExpiryDate;
    private Double price;
    private Double discountPrice;
    private Double originalPrice;
}
    