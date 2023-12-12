package com.example.doctorkom.Services.UserProfileService;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Services.EntityServices.AccountService;
import com.example.doctorkom.Services.EntityServices.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PatientProfileServiceTest {

    @Mock
    private AccountService accountService;

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientProfileService patientProfileService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserProfile() {
        // Arrange
        int id = 1;
        String username = "testUser";
        PatientDTO expectedPatientDTO = PatientDTO.builder().build();
        when(accountService.existAccount(username)).thenReturn(true);
        when(accountService.getAccount(username)).thenReturn(AccountDTO.builder().id(id).build());
        when(patientService.getPatient(anyInt())).thenReturn(expectedPatientDTO);

        // Act
        PatientDTO result = patientProfileService.getUserProfile(username);

        // Assert
        assertNotNull(result);
        assertEquals(expectedPatientDTO, result);
        verify(accountService, times(1)).existAccount(username);
        verify(accountService, times(1)).getAccount(username);
        verify(patientService, times(1)).getPatient(anyInt());
    }

    @Test
    public void testUpdateUserProfile() {
        // Arrange
        PatientDTO patientDTO = PatientDTO.builder().build();

        // Act
        patientProfileService.updateUserProfile(patientDTO);

        // Assert
        verify(patientService, times(1)).updatePatient(patientDTO);
    }
}
