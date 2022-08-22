package com.example.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "invoices")
@Entity
public class Invoices {

//    todo to add the constructor
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "tenant_id", nullable = false, unique = true)
    private Long tenantId;
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

    @Override
    public String toString() {
        return "Invoices{" +
                "id=" + id +
                ", tenantId=" + tenantId +
                ", dateAdded=" + dateAdded +
                ", dueDate=" + dueDate +
                ", particulars='" + particulars + '\'' +
                ", amount=" + amount +
                ", isPaid=" + isPaid +
                ", houseId=" + houseId +
                '}';
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}