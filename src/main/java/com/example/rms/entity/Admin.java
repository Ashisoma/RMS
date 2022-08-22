package com.example.rms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "admin")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "admin_sequence")
    @SequenceGenerator(name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1)
    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "f_name", nullable = false, length = 15)
    private String f_name;

    @Column(name = "s_name", nullable = false, length = 15)
    private String s_name;

    @Column(name = "national_id", unique = true, nullable = false, length = 8)
    private Integer nationalId;

    @Column(name = "email", unique = true, nullable = false, length = 20)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "sign_up_date", nullable = false)
    private LocalDate signUpDate;

    @Column(name = "email_confirmed", nullable = false, length = 1)
    private boolean emailConfirmed;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @JsonIgnore
    @OneToMany(
            mappedBy = "ownedBy",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @ToString.Exclude
    private List<Houses> housesList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "admin",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @ToString.Exclude
    private List<Payment> paymentList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Admin admin = (Admin) o;
        return id != null && Objects.equals(id, admin.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}