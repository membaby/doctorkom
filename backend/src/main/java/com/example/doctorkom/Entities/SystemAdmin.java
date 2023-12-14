package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "SystemAdmin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemAdmin {
    @Id
    @Column(name = "AccountId")
    private Integer id;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountId")
    private Account account;
}
