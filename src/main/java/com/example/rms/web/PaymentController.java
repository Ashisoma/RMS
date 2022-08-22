package com.example.rms.web;

import com.example.rms.entity.Payment;
import com.example.rms.repository.PaymentRepository;
import com.example.rms.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/rms/payment")
public class PaymentController {

    @Autowired
    private final PaymentService service;

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Payment> getAll(){
        return service.getAllPaymentsDone();
    }

    @GetMapping(path = "/{id}")
    public Optional<Payment> getHouseById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(path = "/payment/{paymentDate}/houses/{houseNumber}")
    public List<Payment> findByPaymentDateAndHouses_HouseNumberIgnoreCase(@PathVariable("paymentDate ") LocalDate paymentDate,
                                   @PathVariable("houseNumber ") String houseNumber){
        return service.findByPaymentDateAndHouses_HouseNumberIgnoreCase(paymentDate,houseNumber);
    }

    @GetMapping(path = "/tenant/{tenantSId}")
    public List<Payment> paymentListByTenant(@PathVariable("tenantSId") Long tenantSId){
        return service.paymentListByTenant(tenantSId);
    }
    @GetMapping(path = "/admin/{id}")
    public List<Payment> findPaymentsRecByAdmin(@PathVariable("id")Long id){
        return service.findPaymentsRecByAdmin(id);
    }

    // POST
    @PostMapping(path = "/add")
    public void addNewPayment(@RequestBody Payment payment){
        service.addNewPayment(payment);
    }

    //PUT
    @PutMapping(path = "/put/{id}")
    public  void editAPayment(@PathVariable("id") Long id,
                            @RequestParam (required = false)String houseNumber,
                            @RequestParam (required = false)String tenantName,
                            @RequestParam (required = false)Float amountPayed,
                            @RequestParam(required = false)String comment){
        service.updateTenant(id,tenantName,houseNumber,amountPayed,comment);
    }


    @PutMapping(path = "/makePayment/{houseId}/payment/{paymentId}")
    public Payment addPaymentToHouse(@PathVariable("houseId")Long houseId,
                                   @PathVariable("paymentId")Long paymentId){
        Payment payment = service.findById(paymentId).get();
        service.assignPaymentToHouse(houseId,paymentId);
        return paymentRepository.save(payment);

    }
}
