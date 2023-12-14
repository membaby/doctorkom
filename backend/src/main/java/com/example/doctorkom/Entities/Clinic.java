package com.example.doctorkom.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Clinic")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {
    @Id
    @Column(name = "ClinicId")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Email")
    private String email;

    @Column(name = "MobilePhone")
    private String mobilePhone;

    @Column(name = "LandlinePhone")
    private String landlinePhone;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ClinicId")
    private ClinicAdmin admin;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TimeSlot> timeSlots;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "WorksFor",
            joinColumns = @JoinColumn(name = "ClinicId"),
            inverseJoinColumns = @JoinColumn(name = "DoctorId")
    )
    @ToString.Exclude
    private List<Doctor> doctors;

    public void addTimeSlot (TimeSlot timeSlot) {
        if (timeSlots == null) {
            timeSlots = new ArrayList<>();
        }

        timeSlots.add(timeSlot);
        timeSlot.setClinic(this);
    }

    void removeTimeSlot (TimeSlot timeSlot) {
        if (timeSlots != null) {
            timeSlots.remove(timeSlot);
            timeSlot.setDoctor(null);
        }
    }

    public void addDoctor (Doctor doctor) {
        if (doctors == null) {
            doctors = new ArrayList<>();
        }

        doctors.add(doctor);
        doctor.getClinics().add(this);
    }

    void removeDoctor (Doctor doctor) {
        if (doctors != null) {
            doctors.remove(doctor);
            doctor.getClinics().remove(this);
        }
    }
      
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Clinic clinic = (Clinic) o;
        return getId() != null && Objects.equals(getId(), clinic.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}