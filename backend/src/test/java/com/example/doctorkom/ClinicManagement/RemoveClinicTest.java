package com.example.doctorkom.ClinicManagement;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Repositories.ClinicRepository;
import com.example.doctorkom.Services.ClinicService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RemoveClinicTest {

    @Mock
    private ClinicRepository clinicRepository;

    private ClinicService clinicService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        clinicService = new ClinicService(clinicRepository);
    }

    @Test
    public void testRemoveClinic_Success() {
        // Create a sample clinic
        Clinic clinic = new Clinic();
        clinic.setId(1); // Assuming the clinic ID is 1

        // Call the removeClinic method
        String result = clinicService.removeClinic(clinic);

        // Verify that the deleteById method was called with the correct clinic ID
        //mock objects created
        Mockito.verify(clinicRepository, Mockito.times(1)).deleteById(clinic.getId());

        // Verify the expected result
        assertEquals("Done", result);
    }


@Test
public void testRemoveClinic_ClinicNotFound() {
    Clinic clinic = new Clinic();
    clinic.setId(1);

    // absence of value
    when(clinicRepository.findById(1)).thenReturn(null);

    String result = clinicService.removeClinic(clinic);

    assertEquals("Done", result);
}



    @Test
    public void testRemoveClinic_NullClinic() {
        String result = clinicService.removeClinic(null);

        verify(clinicRepository, never()).deleteById(anyInt());

        assertEquals("Done", result);
    }
}