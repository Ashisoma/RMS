package com.example.rms.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    // here there is also need for inheritance and many to many implementation

    @GeneratedValue(
            strategy = GenerationType.AUTO
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
                    name = "admin_payment_fk"
            )
    )
    private Admin admin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Payment payment = (Payment) o;
        return id != null && Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    public void addPayment(Houses houses) {
        this.houses = houses;
    }
}
