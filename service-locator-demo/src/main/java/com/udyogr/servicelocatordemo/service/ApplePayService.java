package com.udyogr.servicelocatordemo.service;

import org.springframework.stereotype.Service;

@Service("ApplePay")
public class ApplePayService implements PaymentService {
    @Override
    public String pay(Double amount) {
        return String.format("Payment of %.2f processing using Apple Pay", amount);
    }
}
