package com.hsgumussoy.payment.payment.web;

import com.hsgumussoy.payment.payment.api.PaymentMapper;
import com.hsgumussoy.payment.payment.api.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController{

    private final PaymentService service;

    @GetMapping
    public String test(){
        return "payment test";
    }
    /*public List<PaymentResponse> getAllPayments() {
        return PaymentMapper.mapToResponses(service.getAll());
    }

    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(@PathVariable String id) {
        return PaymentMapper.toResponse(service.getById(id));
    }

    @PostMapping()
    public PaymentResponse createPayment(@RequestBody PaymentRequest request) {
        return PaymentMapper.toResponse(service.save(PaymentMapper.toDto(request)));
    }

    @PutMapping("/{id}")
    public PaymentResponse updatePayment(@PathVariable String id, @RequestBody PaymentRequest request) {
        return PaymentMapper.toResponse(service.update(id, PaymentMapper.toDto(request)));
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable String id) {
        service.delete(id);
    }*/
}

    