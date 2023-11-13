package com.example.doctorkom.DAOs;

import com.example.doctorkom.Entities.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AccountDAO {
    private final EntityManager entityManager;

    @Autowired
    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void insert(Account account){
        entityManager.persist(account);
    }

    @Transactional
    public void update(Account account){
        entityManager.merge(account);
    }

    @Transactional
    public void delete(Integer id){
        Account account = findById(id);
        entityManager.remove(account);
    }

    @Transactional
    public Integer deleteAll(){
        Integer rowsAffectedNo = entityManager.createQuery("DELETE FROM Account").executeUpdate();
        return rowsAffectedNo;
    }

    public Account findById(Integer id){
        return entityManager.find(Account.class, id);
    }

    public List<Account> findAll(){
        TypedQuery<Account> query = entityManager.createQuery("FROM Account", Account.class);
        return query.getResultList();
    }
}
