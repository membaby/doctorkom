package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.AccountMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAccount() {
        // Arrange
        String username = "testUser";
        AccountDTO expectedAccountDTO = AccountDTO.builder().
                username(username).
                build();

        when(accountRepository.findByUsername(username)).thenReturn(Optional.of(Account.builder().build()));
        when(accountMapper.toDto(any())).thenReturn(expectedAccountDTO);

        // Act
        AccountDTO result = accountService.getAccount(username);

        // Assert
        assertNotNull(result);
        assertEquals(expectedAccountDTO, result);
        verify(accountRepository, times(2)).findByUsername(username);
        verify(accountMapper, times(1)).toDto(any());
    }

    @Test
    public void testUpdateAccount() {
        // Arrange
        AccountDTO accountDTO = AccountDTO.builder().build();
        Account account = Account.builder().build();

        when(accountRepository.findByUsername(accountDTO.getUsername())).thenReturn(Optional.of(account));
        when(accountMapper.toEntity(accountDTO)).thenReturn(account);

        // Act
        accountService.updateAccount(accountDTO);

        // Assert
        verify(accountRepository, times(1)).findByUsername(accountDTO.getUsername());
        verify(accountRepository, times(1)).save(account);
    }


    @Test
    public void testExistAccount() {
        // Arrange
        String username = "testUser";
        when(accountRepository.findByUsername(username)).thenReturn(Optional.of(Account.builder().build()));

        // Act
        boolean result = accountService.existAccount(username);

        // Assert
        assertTrue(result);
        verify(accountRepository, times(1)).findByUsername(username);
    }

    @Test
    public void testExistAccount_NotFound() {
        // Arrange
        String username = "nonExistentUser";
        when(accountRepository.findByUsername(username)).thenReturn(Optional.empty());

        // Act
        boolean result = accountService.existAccount(username);

        // Assert
        assertFalse(result);
        verify(accountRepository, times(1)).findByUsername(username);
    }
}
