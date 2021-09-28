package com.rms.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String house_number;
    private String features;
    private float rent;
    private boolean is_occupied;

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }

    public void setIs_occupied(boolean is_occupied) {
        this.is_occupied = is_occupied;
    }

    public Long getId() {
        return id;
    }

    public String getHouse_number() {
        return house_number;
    }

    public String getFeatures() {
        return features;
    }

    public float getRent() {
        return rent;
    }

    public boolean isIs_occupied() {
        return is_occupied;
    }

}
