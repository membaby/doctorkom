package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
    Account findByUsername(String username);
    Account findByRole(Role role);
    void deleteByEmail(String mail);
    void deleteByUsername(String johnSmith1);
}