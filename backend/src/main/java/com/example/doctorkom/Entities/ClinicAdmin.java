package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "ClinicAdmin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicAdmin {
    @Id
    @Column(name = "AccountId")
    private Integer id;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountId")
    private Account account;
}
