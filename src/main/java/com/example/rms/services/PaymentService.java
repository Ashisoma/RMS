package com.example.rms.services;

import com.example.rms.domain.Admin;
import com.example.rms.domain.Payment;
import com.example.rms.domain.Tenants;
import com.example.rms.repository.AdminRepository;
import com.example.rms.repository.PaymentRepository;
import com.example.rms.repository.TenantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;
    @Autowired
    private final TenantsRepository tenantsRepository;
    private final AdminRepository adminRepository;

    public PaymentService(PaymentRepository paymentRepository, TenantsRepository tenantsRepository, AdminRepository adminRepository) {
        this.paymentRepository = paymentRepository;
        this.tenantsRepository = tenantsRepository;
        this.adminRepository = adminRepository;
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

    public List<Payment> findByTimestampAndHouses_HouseNumber(LocalDateTime timestamp, String houseNumber){
        return paymentRepository.findByTimestampAndHouses_HouseNumber(timestamp,houseNumber);
    }
//    BY A TENANT
    public List<Payment> paymentListByTenant(Long tenantSId){
        Tenants tenantId = tenantsRepository.findById(tenantSId).get();
        return paymentRepository.findByHouses_Tenant_Id(tenantId);
    }
//    PAYMENTS RECEIVED BY AN ADMIN
    public List<Payment> findPaymentsRecByAdmin(Long id){
        Admin adminId = adminRepository.findById(id).get();
        return paymentRepository.findByHouses_OwnedBy_Id(adminId);
    }
//    DO A PAYMENT
public void addNewPayment(Payment payment) {
    paymentRepository.save(payment);
}
//    UPDATE A PAYMENT
}
