package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Verification")
@Data
@Builder
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
}