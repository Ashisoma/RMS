package com.example.rms.web;

import com.example.rms.domain.Payment;
import com.example.rms.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PaymentController {

    @Autowired
    private final PaymentService service;

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

    @GetMapping(path = "/payment/{timestamp}/houses/{houseNumber}")
    public List<Payment> findByTimestampAndHouses_HouseNumber(@PathVariable("timestamp ") LocalDateTime timestamp,
                                   @PathVariable("houseNumber ") String houseNumber){
        return service.findByTimestampAndHouses_HouseNumber(timestamp,houseNumber);
    }

    @GetMapping(path = "/tenant/{tenantSId}")
    public List<Payment> paymentListByTenant(@PathVariable("tenantSId") Long tenantSId){
        return service.paymentListByTenant(tenantSId);
    }
    @GetMapping(path = "/admin/{id]")
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
    public  void editAHouse(@PathVariable("id") Long id,
                            @RequestParam (required = false)String houseNumber,
                            @RequestParam (required = false)String features,
                            @RequestParam (required = false)Float rent,
                            @RequestParam (required = false)boolean isOccupied){
    }
}
