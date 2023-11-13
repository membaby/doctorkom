package com.example.doctorkom.DAOs;

import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DoctorDAO {
    private final EntityManager entityManager;

    @Autowired
    public DoctorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void insert(Doctor doctor){
        entityManager.persist(doctor);
    }

    @Transactional
    public void delete(Integer id){
        Doctor doctor = findById(id);
        entityManager.remove(doctor);
    }

    public Doctor findById(Integer id){
        return entityManager.find(Doctor.class, id);
    }

    public List<Doctor> findAll(){
        TypedQuery<Doctor> query = entityManager.createQuery("FROM Doctor", Doctor.class);
        return query.getResultList();
    }
}