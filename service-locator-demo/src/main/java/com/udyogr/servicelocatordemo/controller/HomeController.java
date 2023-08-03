package com.udyogr.servicelocatordemo.controller;

import com.udyogr.servicelocatordemo.model.PaymentMethod;
import com.udyogr.servicelocatordemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ApplePayService applePayService;
    @Autowired
    private GooglePayService googlePayService;
    @Autowired
    private SquarePayService squarePayService;

    @Autowired
    private PaymentRegistry paymentRegistry;

    @GetMapping("/pay1")
    public ResponseEntity<String> processPayment(@RequestBody PaymentMethod paymentMethod) {

        String message = "";

        switch (paymentMethod.getMethod()) {
            case "ApplePay" : message = applePayService.pay(paymentMethod.getAmount()); break;
            case "GooglePay" : message = googlePayService.pay(paymentMethod.getAmount()); break;
            case "SquarePay" : message = squarePayService.pay(paymentMethod.getAmount()); break;
            default: break;
        }

        return ResponseEntity.ok(message);
    }

    @GetMapping("/pay2")
    public ResponseEntity<String> processPayment2(@RequestBody PaymentMethod paymentMethod) {
        PaymentService paymentService = paymentRegistry.getPaymentService(paymentMethod.getMethod());
        String message = paymentService.pay(paymentMethod.getAmount());
        return ResponseEntity.ok(message);
    }
}
