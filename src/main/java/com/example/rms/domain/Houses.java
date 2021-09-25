package com.example.rms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table
@Entity
public class Houses extends Admin{

    @Id
    @Column(name = "id",unique = true, nullable = false)
    private Long id;

    @Column(name = "house_number",nullable = false)
    private String houseNumber;


    @Column(name = "features",nullable = false)
    private String features;

    @Column(name = "rent",nullable = false)
    private Float rent;

    @Column(name = "is_occupied",nullable = false)
    private boolean isOccupied;

    public Houses() {
    }

    // inheritance in spring boot to get data from the two tables and display for the house, admin, tenant, payments
    public Houses(String f_name, String s_name, Integer national_id, String email, String password, LocalDate sign_up_date, boolean emailConfirmed, String gender, Long id, String houseNumber, String features, Float rent, boolean isOccupied) {
        super(f_name, s_name, national_id, email, password, sign_up_date, emailConfirmed, gender);
        this.id = id;
        this.houseNumber = houseNumber;
        this.features = features;
        this.rent = rent;
        this.isOccupied = isOccupied;
    }

    public Houses(Long id, String houseNumber, String features, Float rent, boolean isOccupied) {
        this.id = id;
        this.houseNumber = houseNumber;
        this.features = features;
        this.rent = rent;
        this.isOccupied = isOccupied;
    }

    public Houses(String houseNumber, String features, Float rent, boolean isOccupied) {
        this.houseNumber = houseNumber;
        this.features = features;
        this.rent = rent;
        this.isOccupied = isOccupied;
    }

    @Override
    public String toString() {
        return "Houses{" +
                "id=" + id +
                ", houseNumber='" + houseNumber + '\'' +
                ", features='" + features + '\'' +
                ", rent=" + rent +
                ", isOccupied=" + isOccupied +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Float getRent() {
        return rent;
    }

    public void setRent(Float rent) {
        this.rent = rent;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}