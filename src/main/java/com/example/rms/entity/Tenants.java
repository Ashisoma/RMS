package com.example.rms.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Tenants {

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


}
