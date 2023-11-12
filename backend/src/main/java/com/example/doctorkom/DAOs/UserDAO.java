package com.example.doctorkom.DAOs;

import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAO {
    private final EntityManager entityManager;

    @Autowired
    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void insert(User user){
        entityManager.persist(user);
    }

    @Transactional
    public void delete(Integer id){
        User user = findById(id);
        entityManager.remove(user);
    }

    public User findById(Integer id){
        return entityManager.find(User.class, id);
    }

    public List<User> findAll(){
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }
}
