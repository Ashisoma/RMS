package com.example.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "invoices")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoices {

//    todo to do one to on with the tenant clas
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn
    @OneToOne
    private Tenants tenantId;

    @Column(name = "date_added", nullable = false)
    private LocalDate dateAdded;
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;
    @Column(name = "particulars", nullable = false)
    private String particulars;
    @Column(name = "amount", nullable = false)
    private Float amount;
    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;
    @Column(name = "house_id", nullable = false, unique = true)
    private Long houseId;

}