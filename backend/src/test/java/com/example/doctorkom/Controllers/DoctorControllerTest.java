package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Entities.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.print.Doc;
import java.sql.Date;

import static org.mockito.Mockito.*;

@SpringBootTest
class DoctorControllerTest {
    private MockMvc mockMvc;

    @Autowired
    DoctorMapper doctorMapper;

    @Mock
    private DoctorController doctorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
    }

    @Test
    void testGetDoctorProfile() throws Exception {
        String username = "testUsername";
        when(doctorController.getDoctorProfile(username)).thenReturn(DoctorDTO.builder().id(1).build());

        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/profile")
                        .param("username", username))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

//    @Test
//    public void testUpdateDoctorProfile() throws Exception {
//        // Given
//        DoctorDTO doctorDTO = DoctorDTO.builder().id(1).build();
//
//        // When
//        mockMvc.perform(MockMvcRequestBuilders.put("/doctor/profile")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(doctorDTO)))
//                        .andExpect(MockMvcResultMatchers.status().isOk());
//
//        // Then
//        verify(doctorController).updateDoctorProfile(doctorDTO);
//    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}