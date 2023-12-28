package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.doctorkom.Services.Search.SearchService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SearchControllerTest {

    @Mock
    private SearchService searchService;

    @InjectMocks
    private SearchController searchController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
    }

    @Test
    void searchDoctors_ReturnsListOfDoctors() throws Exception {
        // Mock data
        Page<DoctorDTO> doctors = Mockito.mock(Page.class);

        // When
        when(searchService.searchDoctorsByDoctorAndClinic(anyMap(), eq(1))).thenReturn(doctors);

        // Perform the request and assert the response
        mockMvc.perform(get("/search/doctors?name=Galal&specialty=PRE&pageCount=1"))
                .andExpect(status().isOk());
    }

    @Test
    void searchClinics_ReturnsListOfClinics() throws Exception {
        // Mock data
        Page<ClinicDTO> clinics = Mockito.mock(Page.class);

        // When
        when(searchService.searchClinics(anyMap(), eq(1))).thenReturn(clinics);

        // Perform the request and assert the response
        mockMvc.perform(get("/search/clinics?name=Quinn Clinic&pageCount=1"))
                .andExpect(status().isOk());
    }
}
