package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PatientControllerTest {
    private MockMvc mockMvc;

    @Mock
    private PatientController patientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
    }

//    @Test
//    void testGetPatientProfile() throws Exception {
//        String username = "testUsername";
//        when(patientController.getPatientProfile(username)).thenReturn(PatientDTO.builder().id(1).build());
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/patient/profile")
//                        .param("username", username))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
//    }
}