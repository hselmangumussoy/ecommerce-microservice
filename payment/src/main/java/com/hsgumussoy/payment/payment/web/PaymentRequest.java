package com.hsgumussoy.payment.payment.web;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaymentRequest {
    private String userId;
    private String orderNumber;
    private String cardNo;
    private String cardHolderName;
    private String cardExpiryDate;
}