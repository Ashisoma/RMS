package com.example.rms.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "admin")
@Entity
public class Admin {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
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
    private Integer national_id;

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

    public Admin() {
    }

    public Admin(Long id, String f_name, String s_name, Integer national_id, String email, String password, LocalDate sign_up_date, boolean emailConfirmed, String gender) {
        this.id = id;
        this.f_name = f_name;
        this.s_name = s_name;
        this.national_id = national_id;
        this.email = email;
        this.password = password;
        this.signUpDate = sign_up_date;
        this.emailConfirmed = emailConfirmed;
        this.gender = gender;
    }

    public Admin(String f_name, String s_name, Integer national_id, String email, String password, LocalDate sign_up_date, boolean emailConfirmed, String gender) {
        this.f_name = f_name;
        this.s_name = s_name;
        this.national_id = national_id;
        this.email = email;
        this.password = password;
        this.signUpDate = sign_up_date;
        this.emailConfirmed = emailConfirmed;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", f_name='" + f_name + '\'' +
                ", s_name='" + s_name + '\'' +
                ", national_id=" + national_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", sign_up_date=" + signUpDate +
                ", emailConfirmed=" + emailConfirmed +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Integer getNational_id() {
        return national_id;
    }

    public void setNational_id(Integer national_id) {
        this.national_id = national_id;
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

    public boolean getEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}