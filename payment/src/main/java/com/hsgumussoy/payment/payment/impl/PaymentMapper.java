package com.hsgumussoy.payment.payment.impl;

import com.hsgumussoy.payment.payment.api.PaymentDto;

public class PaymentMapper {

    private PaymentMapper() {
    }

    public static PaymentDto toDto(Payment payment) {
        return PaymentDto.builder()
                .id(payment.getId())
                .userId(payment.getUser().getId())
                .orderNumber(payment.getOrderNumber())
                .cardNo(payment.getCardNo())
                .cardHolderName(payment.getCardHolderName())
                .cardExpiryDate(payment.getCardExpiryDate())
                .build();
    }

    public static Payment toEntity(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.getUser().setId(paymentDto.getUserId());
        payment.setOrderNumber(paymentDto.getOrderNumber());
        payment.setCardNo(paymentDto.getCardNo());
        payment.setCardHolderName(paymentDto.getCardHolderName());
        payment.setCardExpiryDate(paymentDto.getCardExpiryDate());
        return payment;
    }

}

    