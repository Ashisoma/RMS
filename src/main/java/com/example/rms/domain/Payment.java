package com.example.rms.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Payment {

    // todo : here there is also need for inheritance and many to many implementation

//    @SequenceGenerator(
//            name = "payment_sequence",
//            sequenceName = "payment_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
//            generator = "payment_sequence"
    )


    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String tenantName;

    @Column(unique = true, nullable = false)
    private String houseNumber;

    @Column(unique = true, nullable = false)
    private LocalDate paymentDate;

    @Column(unique = true, nullable = false)
    private Float amountPayed;

    @Column(unique = true)
    private String comment;

    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name = "houses_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "houses_payment_fk"
            )
    )
    private Houses houses;

    @ManyToOne
    @JoinColumn(name = "admin_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "houses_payment_fk"
            )
    )
    private  Admin admin;

    public Payment() {
    }

    public Payment(Long id, String tenantName, String houseNumber, LocalDate paymentDate, Float amountPayed, String comment) {
        this.id = id;
        this.tenantName = tenantName;
        this.houseNumber = houseNumber;
        this.paymentDate = paymentDate;
        this.amountPayed = amountPayed;
        this.comment = comment;
    }

    public Payment(String tenantName, String houseNumber, LocalDate paymentDate, Float amountPayed, String comment) {
        this.tenantName = tenantName;
        this.houseNumber = houseNumber;
        this.paymentDate = paymentDate;
        this.amountPayed = amountPayed;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", tenantName=" + tenantName +
                ", houseNumber='" + houseNumber + '\'' +
                ", paymentDate=" + paymentDate +
                ", amountPayed=" + amountPayed +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Houses getHouses() {
        return houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }



    public Float getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(Float amountPayed) {
        this.amountPayed = amountPayed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
