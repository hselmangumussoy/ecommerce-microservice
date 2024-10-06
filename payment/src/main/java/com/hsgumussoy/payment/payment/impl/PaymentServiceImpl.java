package com.hsgumussoy.payment.payment.impl;

import com.hsgumussoy.payment.payment.api.PaymentDto;
import com.hsgumussoy.payment.payment.api.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    //private final UserService userService;

    @Override
    public PaymentDto getById(String id) {
        Payment payment = repository.findById(id).orElseThrow();
        return PaymentMapper.toDto(payment);
    }

    @Override
    public PaymentDto update(String id, PaymentDto dto) {
        return  null;
    }

    @Override
    public void delete(String id) {
        var payment = repository.findById(id).orElseThrow();
        repository.delete(payment);
    }

    @Override
    public PaymentDto save(PaymentDto dto) {
        return PaymentMapper.toDto(repository.save(PaymentMapper.toEntity(dto)));
    }
    @Override
    public Page<PaymentDto> getAll() {
        return null;
    }


}



    