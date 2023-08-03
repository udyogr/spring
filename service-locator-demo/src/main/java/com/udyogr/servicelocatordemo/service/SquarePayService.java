package com.udyogr.servicelocatordemo.service;

import org.springframework.stereotype.Service;

@Service("SquarePay")
public class SquarePayService implements PaymentService {
    @Override
    public String pay(Double amount) {
        return String.format("Amount of %.2f processed using Square pay", amount);
    }
}
