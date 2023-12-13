package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Verification")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Verification {
    @Id
    @Column(name = "AccountId")
    private Integer id;

    @Column(name = "Code")
    private String code;

    @Column(name = "ExpirationTime")
    private LocalDateTime expirationTime;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "AccountId")
    private Account account;

    public Verification(String code, LocalDateTime expirationTime, Account account) {
        this.code = code;
        this.expirationTime = expirationTime;
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Verification that = (Verification) o;
        return id != null && Objects.equals(id, that.id);
    }
}