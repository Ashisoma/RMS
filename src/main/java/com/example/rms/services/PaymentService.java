package com.example.rms.services;

import com.example.rms.entity.Admin;
import com.example.rms.entity.Houses;
import com.example.rms.entity.Payment;
import com.example.rms.entity.Tenants;
import com.example.rms.repository.AdminRepository;
import com.example.rms.repository.HousesRepository;
import com.example.rms.repository.PaymentRepository;
import com.example.rms.repository.TenantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;
    @Autowired
    private final TenantsRepository tenantsRepository;
    @Autowired
    private final AdminRepository adminRepository;
    @Autowired
    private final HousesRepository housesRepository;

    public PaymentService(PaymentRepository paymentRepository, TenantsRepository tenantsRepository, AdminRepository adminRepository, HousesRepository housesRepository) {
        this.paymentRepository = paymentRepository;
        this.tenantsRepository = tenantsRepository;
        this.adminRepository = adminRepository;
        this.housesRepository = housesRepository;
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

    public List<Payment> findByPaymentDateAndHouses_HouseNumberIgnoreCase(LocalDate paymentDate, String houseNumber){
        return paymentRepository.findByPaymentDateAndHouses_HouseNumberIgnoreCase(paymentDate,houseNumber);
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
       Optional <Payment> paymentById = paymentRepository.findById(payment.getId());
    if(paymentById.isPresent()){
        throw new IllegalStateException("Payment id already exists");
    }
        paymentRepository.save(payment);
//    return payment;
}
//    UPDATE A PAYMENT
public void updateTenant(Long id, String tenantName, String houseNumber, Float amountPayed, String comment) {
    Payment payment = paymentRepository.findById(id).orElseThrow(() ->
            new IllegalStateException("Student with id :" + id + "does not exist"));
    if (tenantName != null && tenantName.length() > 0 && !Objects.equals(payment.getTenantName(), tenantName)) {
        payment.setTenantName(tenantName);
    }
    if (houseNumber != null && houseNumber.length() > 0 && !Objects.equals(payment.getHouseNumber(), houseNumber)) {
        payment.setTenantName(houseNumber);
    }
    if (amountPayed !=null && !Objects.equals(payment.getAmountPayed(), amountPayed)) {
        payment.setAmountPayed(amountPayed);
    }
    if (comment != null && comment.length() > 0 && !Objects.equals(payment.getComment(), comment)) {
        payment.setComment(comment);
    }
//    TODO FINISH THE UPDATE FOR THE PAYMENT
}
    @Transactional
    public void assignPaymentToHouse(Long houseId, Long paymentId){
        Houses house = housesRepository.findById(houseId).get();
        Payment payment = paymentRepository.findById(paymentId).get();
        boolean paymentExists = paymentRepository.existsById(paymentId);
        boolean houseExists = housesRepository.existsById(houseId);
        if (!paymentExists && !houseExists){
            throw  new IllegalStateException("Payment with id :"+ paymentId +" and house id:"+ houseId +" cant be enrolled. Error enrolling admin");
        }else {
            payment.addPayment(house);
        }
    }
}
