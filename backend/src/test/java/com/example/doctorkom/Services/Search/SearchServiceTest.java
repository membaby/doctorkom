package com.example.doctorkom.Services.Search;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
// import com.example.doctorkom.Services.EntityServices.ClinicService;
import com.example.doctorkom.Services.EntityServices.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class SearchServiceTest {

    @Mock
    private DoctorService doctorService;

    @Mock
    // private ClinicService clinicService;

    @InjectMocks
    private SearchService searchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchDoctors() {
        // Arrange
        Map<String, String> searchParams = new HashMap<>();
        searchParams.put("specialty", "CARDIOLOGIST");
        searchParams.put("title", "CONSULTANT");


        // Mock data
        Page<Doctor> expectedDoctors = Mockito.mock(Page.class);

        // When
        when(doctorService.findAllDoctors(Mockito.any(), eq(10))).thenReturn(expectedDoctors);

        // Act
        Page<Doctor> actualDoctors = searchService.searchDoctors(searchParams, 10);

        // Assert
        assertEquals(expectedDoctors, actualDoctors);
    }

    // @Test
    // void searchClinics() {
    //     // Arrange
    //     Map<String, String> searchParams = new HashMap<>();
    //     searchParams.put("name", "Quinn Clinic");
    //     searchParams.put("email", "quinnClinic123@hospital.com");

    //     // Mock data
    //     Page<Clinic> expectedClinics = Mockito.mock(Page.class);

    //     // When
    //     when(clinicService.findAllClinics(Mockito.any(), eq(10))).thenReturn(expectedClinics);

    //     // Act
    //     Page<Clinic> actualClinics = searchService.searchClinics(searchParams, 10);

    //     // Assert
    //     assertEquals(expectedClinics, actualClinics);
    // }

    @Test
    void searchDoctorsByDoctorAndClinic() {
        // Arrange
        Map<String, String> searchParams = new HashMap<>();
        searchParams.put("name", "John");
        searchParams.put("city", "New York");
        searchParams.put("specialty", "CARDIOLOGIST");
        searchParams.put("title", "CONSULTANT");

        // Mock data
        Page<Doctor> expectedDoctors = Mockito.mock(Page.class);

        // When
        when(doctorService.findAllDoctors("John", "New York", DoctorSpecialty.CARDIOLOGIST, DoctorTitle.CONSULTANT, 10))
                .thenReturn(expectedDoctors);

        // Act
        Page<Doctor> actualDoctors = searchService.searchDoctorsByDoctorAndClinic(searchParams, 10);

        // Assert
        assertEquals(expectedDoctors, actualDoctors);
    }
}
