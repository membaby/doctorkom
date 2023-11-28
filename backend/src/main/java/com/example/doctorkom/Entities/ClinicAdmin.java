package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "Clinic_Admin")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClinicAdmin {
    @Id
    @Column(name = "AccountID")
    private Integer accountID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountID")
    private Account account;

    public ClinicAdmin(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClinicAdmin clinicAdmin = (ClinicAdmin) o;
        return accountID != null && Objects.equals(accountID, clinicAdmin.accountID);
    }
}
