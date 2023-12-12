package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.PatientMapper;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Repositories.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPatient() {
        // Arrange
        int patientId = 1;
        PatientDTO expectedPatientDTO = PatientDTO.builder().
                id(patientId).
                build();
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(Patient.builder().build()));
        when(patientMapper.toDto(any())).thenReturn(expectedPatientDTO);

        // Act
        PatientDTO result = patientService.getPatient(patientId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedPatientDTO, result);
        verify(patientRepository, times(2)).findById(patientId);
        verify(patientMapper, times(1)).toDto(any());
    }

    @Test
    public void testUpdatePatient() {
        // Arrange
        PatientDTO patientDTO = PatientDTO.builder().build();
        when(patientRepository.findById(patientDTO.getId())).thenReturn(Optional.of(Patient.builder().build()));

        // Act
        patientService.updatePatient(patientDTO);

        // Assert
        verify(patientRepository, times(1)).findById(patientDTO.getId());
        verify(patientRepository, times(1)).save(any());
    }
}
