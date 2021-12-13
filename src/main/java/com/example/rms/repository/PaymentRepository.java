package com.example.rms.repository;

import com.example.rms.domain.Admin;
import com.example.rms.domain.Payment;
import com.example.rms.domain.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p from Payment p where p.timestamp = ?1 and p.houses.houseNumber = ?2")
    List<Payment> findByTimestampAndHouses_HouseNumber(LocalDateTime timestamp, String houseNumber);

    @Query("select p from Payment p where p.houses.ownedBy.id = ?1")
    List<Payment> findByHouses_OwnedBy_Id(Admin id);

    @Query("select p from Payment p where p.houses.tenant.id = ?1")
    List<Payment> findByHouses_Tenant_Id(Tenants id);

    // find payment by tenant id
    // add payment
    // find all payments made
    //do not edit payment
    // do not delete payment
}