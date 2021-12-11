package com.example.rms.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "houses")
@Entity
public class Houses {

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


    // RELATIONSHIP
    @ManyToOne
    @JoinColumn(name = "owned_by_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "admin_house_fk"
            )
    )
    private Admin ownedBy;

    // TODO: 25/10/2021 finish this editing
    @OneToOne
    @JoinColumn(name = "tenant_id",
            referencedColumnName = "id"
    )
    private Tenants tenant;

    @OneToMany(
            mappedBy = "houses",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    private List<Payment> paymentsMade = new ArrayList<>();

    public Houses() {
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


    public void setOwnedBy(Admin ownedBy) {
        this.ownedBy = ownedBy;
    }

    public void setTenant(Tenants tenant) {
        this.tenant = tenant;
    }

    public List<Payment> getPaymentsMade() {
        return paymentsMade;
    }

    public void setPaymentsMade(List<Payment> paymentsMade) {
        this.paymentsMade = paymentsMade;
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

    public Tenants getTenant() {
        return tenant;
    }

    public Admin getOwnedBy() {
        return ownedBy;
    }

}