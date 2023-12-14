package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>, JpaSpecificationExecutor<Doctor> {
    Optional<List<Doctor>> findByTitle(DoctorTitle title);
    Optional<List<Doctor>> findBySpecialty(DoctorSpecialty specialty);

    @Query("SELECT d FROM Doctor d, Clinic c " +
            "WHERE (:name IS NULL OR LOWER(d.systemUser.firstName) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "OR (:name IS NULL OR LOWER(d.systemUser.lastName) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "OR (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:city IS NULL OR LOWER(c.address) LIKE LOWER(CONCAT('%', :city, '%'))) " +
            "AND (:specialty IS NULL OR d.specialty = :specialty) " +
            "AND (:title IS NULL OR d.title = :title)")
    List<Doctor> findAllDoctorsWithDoctorAndClinic(
            @Param("name") String name,
            @Param("city") String city,
            @Param("specialty") DoctorSpecialty specialty,
            @Param("title") DoctorTitle title);
}