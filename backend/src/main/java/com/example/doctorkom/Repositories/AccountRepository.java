package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmail(String email);
    Optional<Account> findByUsername(String username);
    List<Account> findByRole(Role role);
    void deleteByEmail(String email);
    void deleteByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}