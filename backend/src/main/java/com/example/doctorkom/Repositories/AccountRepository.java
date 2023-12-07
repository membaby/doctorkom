package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    Optional<Account> findByEmail(String email);
    Optional<Account> findByUsername(String username);
    Optional<List<Account>> findByRole(Role role);
    void deleteByEmail(String mail);
    void deleteByUsername(String username);
}