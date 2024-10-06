package com.hsgumussoy.payment.payment.web;

import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@Builder
@ToString
public class PaymentResponse {
    private final String id;
    private final String userId;
    private final String orderNumber;
    private final String cardNo;
    private final String cardHolderName;
    private final String cardExpiryDate;
}
    