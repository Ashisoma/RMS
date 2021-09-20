package com.example.ashisoma.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Payment {

    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )


    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long tenantId;

    @Column(unique = true, nullable = false)
    private String houseNumber;

    @Column(unique = true, nullable = false)
    private Timestamp timestamp;

    @Column(unique = true, nullable = false)
    private Float amountPayed;

    @Column(unique = true, nullable = false)
    private String comment;

    public Payment() {
    }

    public Payment(Long id, Long tenantId, String houseNumber, Timestamp timestamp, Float amountPayed, String comment) {
        this.id = id;
        this.tenantId = tenantId;
        this.houseNumber = houseNumber;
        this.timestamp = timestamp;
        this.amountPayed = amountPayed;
        this.comment = comment;
    }

    public Payment(Long tenantId, String houseNumber, Timestamp timestamp, Float amountPayed, String comment) {
        this.tenantId = tenantId;
        this.houseNumber = houseNumber;
        this.timestamp = timestamp;
        this.amountPayed = amountPayed;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", tenantId=" + tenantId +
                ", houseNumber='" + houseNumber + '\'' +
                ", timestamp=" + timestamp +
                ", amountPayed=" + amountPayed +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
