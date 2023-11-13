package com.example.doctorkom.DAOs;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PatientDAO {
    private final EntityManager entityManager;

    @Autowired
    public PatientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void insert(Patient patient){
        entityManager.persist(patient);
    }

    @Transactional
    public void delete(Integer id){
        Patient patient = findById(id);
        entityManager.remove(patient);
    }

    public Patient findById(Integer id){
        return entityManager.find(Patient.class, id);
    }

    public List<Patient> findAll(){
        TypedQuery<Patient> query = entityManager.createQuery("FROM Patient", Patient.class);
        return query.getResultList();
    }
}

