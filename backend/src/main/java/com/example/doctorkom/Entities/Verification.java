package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Verification")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Verification {
    @Id
    @Column(name = "AccountId")
    private Integer id;

    @Column(name = "Code")
    private String code;

    @Column(name = "ExpirationTime")
    private LocalDateTime expirationTime;

    @MapsId
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "AccountId")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Verification that = (Verification) o;
        return id != null && Objects.equals(id, that.id);
    }
}