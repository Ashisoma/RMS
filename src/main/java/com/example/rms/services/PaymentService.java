package com.example.rms.services;

import com.example.rms.domain.Houses;
import com.example.rms.domain.Payment;
import com.example.rms.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    //GET
//     ALL PAYMENTS DONE
    public List<Payment> getAllPaymentsDone(){
        return paymentRepository.findAll();
    }
//    BY ID
    public Optional<Payment> findById(Long id){
        return paymentRepository.findById(id);
    }
//    TO A PARTICULAR HOUSE
    /*
    public List<Payment> findPaymentByHouse(){

    }
     */
//    BY DATE

//    BY A TENANT
//    PAYMENTS RECEIVED BY AN ADMIN
//    DO A PAYMENT
//    UPDATE A PAYMENT
}
