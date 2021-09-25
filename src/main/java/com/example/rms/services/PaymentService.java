package com.example.rms.services;

import com.example.rms.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    //GET
//     ALL PAYMENTS DONE
//    BY ID
//    TO A PARTICULAR HOUSE
//    BY DATE
//    BY A TENANT
//    PAYMENTS RECEIVED BY AN ADMIN
}
