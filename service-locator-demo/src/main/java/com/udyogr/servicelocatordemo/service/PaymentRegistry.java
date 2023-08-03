package com.udyogr.servicelocatordemo.service;

import org.springframework.stereotype.Service;

public interface PaymentRegistry {
    public PaymentService getPaymentService(String serviceName);
}
