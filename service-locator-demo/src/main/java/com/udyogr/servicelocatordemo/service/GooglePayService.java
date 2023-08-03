package com.udyogr.servicelocatordemo.service;

import org.springframework.stereotype.Service;

@Service("GooglePay")
public class GooglePayService implements PaymentService {
    @Override
    public String pay(Double amount) {
        return String.format("Amount of %.2f processed using Google Pay", amount);
    }
}
