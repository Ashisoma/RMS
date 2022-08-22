package com.example.rms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "houses")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Houses {

    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
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

    @JsonIgnore
    @OneToMany(
            mappedBy = "houses",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    private List<Payment> paymentsMade = new ArrayList<>();

    // END OF RELATIONSHIPS

    // this one should work just fine, many to one
    public void enrollAdmin(Admin admin) {
        this.ownedBy = admin;
    }

    // this is one to one so not yet tried out
    public void addTenant(Tenants tenant) {
        this.tenant = tenant;
    }
}