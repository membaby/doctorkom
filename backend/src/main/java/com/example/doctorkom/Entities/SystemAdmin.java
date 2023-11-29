package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "SystemAdmin")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SystemAdmin {
    @Id
    @Column(name = "AccountId")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountId")
    private Account account;

    public SystemAdmin(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SystemAdmin systemAdmin = (SystemAdmin) o;
        return id != null && Objects.equals(id, systemAdmin.id);
    }
}
