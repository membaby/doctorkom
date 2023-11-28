//package com.example.doctorkom.ClinicManagement;
//
//import com.example.doctorkom.Entities.Clinic;
//import com.example.doctorkom.Repositories.ClinicRepository;
//import com.example.doctorkom.Services.ClinicService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class ClinicCreationTest {
////isolation
//    @Mock
//    private ClinicRepository clinicRepository;
//
//    @InjectMocks
//    private ClinicService clinicService;
//
//    @Test
//    public void testCreateClinic() {
//        // Arrange
//        Clinic clinic = new Clinic("test@example.com", "Test Clinic", "123 Main St", "1234567890", "0987654321");
//
//        // Act
//        String result = clinicService.createClinic(clinic);
//
//        // Assert
//        assertEquals("Clinic created successfully", result);
//        verify(clinicRepository, times(1)).save(clinic);
//    }
//}
package com.example.doctorkom.ClinicManagement;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Repositories.ClinicRepository;
import com.example.doctorkom.Services.ClinicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClinicCreationTest {

    @Mock
    private ClinicRepository clinicRepository;

    @InjectMocks
    private ClinicService clinicService;

    private Clinic testClinic;
    private Clinic testClinicnullEmail ;
    private Clinic testClinicnullName ;
    private Clinic testClinicnullAddress ;
    private Clinic testClinicnullPhone;
    private Clinic testClinicnullLandline ;

    @BeforeEach
    public void setUp() {
        // Initialize a test clinic object
        testClinic = new Clinic("test@example.com", "Test Clinic", "123 Main St", "1234567890", "0987654321");
        testClinicnullEmail = new Clinic(null, "Test Clinic", "123 Main St", "1234567890", "0987654321");
        testClinicnullName= new Clinic("test@example.com", null, "123 Main St", "1234567890", "0987654321");
        testClinicnullAddress= new Clinic("test@example.com", "Test Clinic", null, "1234567890", "0987654321");
        testClinicnullPhone = new Clinic("test@example.com", "Test Clinic", "123 Main St", null, "0987654321");
        testClinicnullLandline= new Clinic("test@example.com", "Test Clinic", "123 Main St", "1234567890", null);

    }

    @Test
    public void testCreateClinic_Success() {
        // Arrange
        when(clinicRepository.save(testClinic)).thenReturn(testClinic);

        // Act
        String result = clinicService.createClinic(testClinic);

        // Assert
        assertEquals("Clinic created successfully", result);
        verify(clinicRepository, times(1)).save(testClinic);
    }

    @Test
    public void testCreateClinic_NullClinic() {
        // Act
        String result = clinicService.createClinic(null);

        // Assert
        assertEquals("Clinic data cannot be null", result);
        verify(clinicRepository, never()).save(any());
    }
    @Test
    public void testCreateClinic_NullEmail() {
        // Act
        String result = clinicService.createClinic(testClinicnullEmail);

        // Assert
        assertEquals("Clinic data cannot be null", result);
        verify(clinicRepository, never()).save(any());
    }
    @Test
    public void testCreateClinic_NullName() {
        // Act
        String result = clinicService.createClinic(testClinicnullName);

        // Assert
        assertEquals("Clinic data cannot be null", result);
        verify(clinicRepository, never()).save(any());
    }
    @Test
    public void testCreateClinic_NullAddress() {
        // Act
        String result = clinicService.createClinic(testClinicnullAddress);

        // Assert
        assertEquals("Clinic data cannot be null", result);
        verify(clinicRepository, never()).save(any());
    }
    @Test
    public void testCreateClinic_NullPhone() {
        // Act
        String result = clinicService.createClinic(testClinicnullPhone);

        // Assert
        assertEquals("Clinic data cannot be null", result);
        verify(clinicRepository, never()).save(any());
    }
    @Test
    public void testCreateClinic_NullLandline() {
        // Act
        String result = clinicService.createClinic(testClinicnullLandline);

        // Assert
        assertEquals("Clinic data cannot be null", result);
        verify(clinicRepository, never()).save(any());
    }

    @Test
    public void testCreateClinic_SaveFailed() {
        // Arrange
        when(clinicRepository.save(testClinic)).thenReturn(null);

        // Act
        String result = clinicService.createClinic(testClinic);

        // Assert
        assertEquals("Creation failed", result);
        verify(clinicRepository, times(1)).save(testClinic);
    }
//
//    @Test
//    public void testRemoveClinic() {
//        // Arrange
//        Integer clinicId = 1;
//        when(clinicRepository.findById(clinicId)).thenReturn(Optional.of(testClinic));
//
//        // Act
//        String result = clinicService.removeClinic(testClinic);
//
//        // Assert
//        assertEquals("Done", result);
//        verify(clinicRepository, times(1)).deleteById(clinicId);
//    }
//
//    @Test
//    public void testRemoveClinic_ClinicNotFound() {
//        // Arrange
//        Integer clinicId = 1;
//        when(clinicRepository.findById(clinicId)).thenReturn(Optional.empty());
//
//        // Act
//        String result = clinicService.removeClinic(testClinic);
//
//        // Assert
//        assertEquals("Clinic not found", result);
//        verify(clinicRepository, never()).deleteById(any());
//    }
}