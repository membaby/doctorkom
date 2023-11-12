package com.example.doctorkom.Unit;

import com.example.doctorkom.DAOs.AccountDAO;
import com.example.doctorkom.Entities.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//Unit tests use H2 in-memory db to perform testing (schema and data found in main/resources)
@ActiveProfiles("test")
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AccountDAOTest {
    @Autowired
    private AccountDAO accountDAO;

    @Test
    public void whenFindByID_thenReturnAccount() {
        // Given
        System.out.println(accountDAO.toString());
        Account account = new Account("hjgf@gmail.com","John_Doe", "hgdsffghjk");
        accountDAO.insert(account);

        // When
        Account found = accountDAO.findById(account.getId());
        // Checking we 're actually using H2
        System.out.println(accountDAO.findAll().get(0));
        System.out.println(accountDAO.findAll().size());

        // Then
        assertEquals(account.getId(), found.getId());
    }

    @Test
    public void whenFindAll_thenReturnAllAccounts() {
        System.out.println(accountDAO.findAll().get(0));
        System.out.println(accountDAO.findAll().size());
    }

    @Test
    public void whenDeleteById_thenDeleteAccount() {
        //Given
        int Id = 1;

        //When
        accountDAO.delete(Id);

        //Then
        assertNull(accountDAO.findById(Id));
        System.out.println(accountDAO.findAll().size());
    }
}
