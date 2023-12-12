package com.example.doctorkom.Services.UserProfileService;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Services.EntityServices.AccountService;
import com.example.doctorkom.Services.EntityServices.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class DoctorProfileServiceTest {

    @Mock
    private AccountService accountService;

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorProfileService doctorProfileService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserProfile() {
        // Arrange
        int id = 1;
        String username = "testUser";
        DoctorDTO expectedDoctorDTO = DoctorDTO.builder().build();
        when(accountService.existAccount(username)).thenReturn(true);
        when(accountService.getAccount(username)).thenReturn(AccountDTO.builder().id(id).build());
        when(doctorService.getDoctor(anyInt())).thenReturn(expectedDoctorDTO);

        // Act
        DoctorDTO result = doctorProfileService.getUserProfile(username);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDoctorDTO, result);
        verify(accountService, times(1)).existAccount(username);
        verify(accountService, times(1)).getAccount(username);
        verify(doctorService, times(1)).getDoctor(anyInt());
    }

    @Test
    public void testUpdateUserProfile() {
        // Arrange
        DoctorDTO doctorDTO = DoctorDTO.builder().build();

        // Act
        doctorProfileService.updateUserProfile(doctorDTO);

        // Assert
        verify(doctorService, times(1)).updateDoctor(doctorDTO);
    }
}
