package com.example.doctorkom.Security;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.HttpHeaders;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPatientRegistrationWithUnauthenticatedUser() throws Exception {
        mockMvc.perform(post("/registration/patient")
                        .with(SecurityMockMvcRequestPostProcessors.anonymous()))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "DOCTOR")
    public void testPatientRegistrationEndpointWithUnauthorizedUser() throws Exception {
        this.mockMvc.
                perform(post("/registration/patient").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "PATIENT")
    public void testPatientRegistrationEndpointWithAuthorizedUser() throws Exception {
        this.mockMvc.
                perform(post("/registration/patient").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    public void testDoctorRegistrationWithUnauthenticatedUser() throws Exception {
        mockMvc.perform(post("/registration/doctor")
                        .with(SecurityMockMvcRequestPostProcessors.anonymous()))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "PATIENT")
    public void testDoctorRegistrationEndpointWithUnauthorizedUser() throws Exception {
        this.mockMvc.
                perform(post("/registration/doctor").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "DOCTOR")
    public void testDoctorRegistrationEndpointWithAuthorizedUser() throws Exception {
        this.mockMvc.
                perform(post("/registration/doctor").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    public void testPatientLoginWithUnauthenticatedUser() throws Exception {
        mockMvc.perform(post("/login/patient")
                        .with(SecurityMockMvcRequestPostProcessors.anonymous()))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "DOCTOR")
    public void testPatientLoginEndpointWithUnauthorizedUser() throws Exception {
        this.mockMvc.
                perform(post("/login/patient").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "PATIENT")
    public void testPatientLoginEndpointWithAuthorizedUser() throws Exception {
        this.mockMvc.
                perform(post("/login/patient").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    public void testDoctorLoginWithUnauthenticatedUser() throws Exception {
        mockMvc.perform(post("/login/doctor")
                        .with(SecurityMockMvcRequestPostProcessors.anonymous()))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "PATIENT")
    public void testDoctorLoginEndpointWithUnauthorizedUser() throws Exception {
        this.mockMvc.
                perform(post("/login/doctor").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "DOCTOR")
    public void testDoctorLoginEndpointWithAuthorizedUser() throws Exception {
        this.mockMvc.
                perform(post("/login/doctor").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }
}
