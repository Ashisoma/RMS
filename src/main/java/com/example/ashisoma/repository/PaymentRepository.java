package com.example.ashisoma.repository;

import com.example.ashisoma.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // find payment by tenant id
    // add payment
    // find all payments made
    //do not edit payment
    // do not delete payment
}