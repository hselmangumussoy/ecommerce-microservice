package com.hsgumussoy.payment.payment.api;

import com.hsgumussoy.payment.payment.web.PaymentRequest;
import com.hsgumussoy.payment.payment.web.PaymentResponse;
import org.springframework.data.domain.Page;


import java.util.List;
import java.util.stream.Collectors;

public class PaymentMapper {

    private PaymentMapper() {
    }

    public static PaymentDto toDto(PaymentRequest paymentRequest) {
        return PaymentDto.builder()
                .userId(paymentRequest.getUserId())
                .orderNumber(paymentRequest.getOrderNumber())
                .cardNo(paymentRequest.getCardNo())
                .cardHolderName(paymentRequest.getCardHolderName())
                .cardExpiryDate(paymentRequest.getCardExpiryDate())
                .build();
    }

    public static PaymentResponse toResponse(PaymentDto paymentDto) {
        return PaymentResponse.builder()
                .id(paymentDto.getId())
                .userId(paymentDto.getUserId())
                .orderNumber(paymentDto.getOrderNumber())
                .cardNo(paymentDto.getCardNo())
                .cardHolderName(paymentDto.getCardHolderName())
                .cardExpiryDate(paymentDto.getCardExpiryDate())
                .build();
    }


    public static List<PaymentResponse> mapToResponses(Page<PaymentDto> dtos) {
        return dtos.stream()
                .map(PaymentMapper::toResponse)
                .collect(Collectors.toList());
    }
}

    