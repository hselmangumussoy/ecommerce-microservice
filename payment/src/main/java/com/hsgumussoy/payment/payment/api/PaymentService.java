package com.hsgumussoy.payment.payment.api;

import org.springframework.data.domain.Page;

public interface PaymentService {
    Page<PaymentDto> getAll();

    PaymentDto getById(String id);

    PaymentDto update(String id, PaymentDto dto);

    void delete(String id);

    PaymentDto save(PaymentDto dto);
}

    