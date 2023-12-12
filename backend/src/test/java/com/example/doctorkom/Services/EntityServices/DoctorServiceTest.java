package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Repositories.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private DoctorMapper doctorMapper;

    @InjectMocks
    private DoctorService doctorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetDoctor() {
        // Arrange
        int doctorId = 1;
        DoctorDTO expectedDoctorDTO = DoctorDTO.builder().
                id(doctorId).
                build();
        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(Doctor.builder().build()));
        when(doctorMapper.toDto(any())).thenReturn(expectedDoctorDTO);

        // Act
        DoctorDTO result = doctorService.getDoctor(doctorId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDoctorDTO, result);
        verify(doctorRepository, times(2)).findById(doctorId);
        verify(doctorMapper, times(1)).toDto(any());
    }

    @Test
    public void testUpdateDoctor() {
        // Arrange
        DoctorDTO doctorDTO = DoctorDTO.builder().build();
        when(doctorRepository.findById(doctorDTO.getId())).thenReturn(Optional.of(Doctor.builder().build()));

        // Act
        doctorService.updateDoctor(doctorDTO);

        // Assert
        verify(doctorRepository, times(1)).findById(doctorDTO.getId());
        verify(doctorRepository, times(1)).save(any());
    }
}
