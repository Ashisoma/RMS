package com.example.rms.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class    Tenants {

    @SequenceGenerator(
            name = "tenant_sequence",
            sequenceName = "tenant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tenant_sequence"
    )

    @Id
    @Column(nullable = false, length = 11)
    private Long id;
    @Column(nullable = false, length = 15)
    private String f_name;
    @Column(nullable = false, length = 15)
    private String l_name;
    @Column(nullable = false, unique = true, length = 10)
    private Integer phone_number;
    @Column(nullable = false, unique = true, length = 25)
    private String email;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(nullable = false)
    private LocalDate signUpDate;
    @Column(nullable = false, length = 1)
    private int emailConfirmed;
    @Column(nullable = false, length = 10)
    private String gender;

    @OneToOne
    @JoinColumn(name = "houses_id",
            referencedColumnName = "id"
    )
    private Houses houses;



    public Tenants() {
    }

    public Tenants(String f_name, String l_name, Integer phone_number, String email, String password, LocalDate signUpDate, int emailConfirmed, String gender) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.signUpDate = signUpDate;
        this.emailConfirmed = emailConfirmed;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Tenants{" +
                "id=" + id +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", SignUpDate=" + signUpDate +
                ", emailConfirmed=" + emailConfirmed +
                ", Gender='" + gender + '\'' +
                '}';
    }

    public Houses getHouses() {
        return houses;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(LocalDate signUpDate) {
        this.signUpDate = signUpDate;
    }

    public int getEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(int emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    //    String
}
