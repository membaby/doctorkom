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
    @WithMockUser(roles = "PATIENT")
    public void testLoginEndpointWithPatientUser() throws Exception {
        this.mockMvc.
                perform(post("/login").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "DOCTOR")
    public void testLoginEndpointWithDoctorUser() throws Exception {
        this.mockMvc.
                perform(post("/login").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "SYSTEM_ADMIN")
    public void testLoginEndpointWithSystemAdmin() throws Exception {
        this.mockMvc.
                perform(post("/login").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "CLINIC_ADMIN")
    public void testLoginEndpointWithClinicAdmin() throws Exception {
        this.mockMvc.
                perform(post("/login").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "PATIENT")
    public void testRecoverPasswordEndpointWithPatientUser() throws Exception {
        this.mockMvc.
                perform(post("/recover_password").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "DOCTOR")
    public void testRecoverPasswordEndpointWithDoctorUser() throws Exception {
        this.mockMvc.
                perform(post("/recover_password").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "SYSTEM_ADMIN")
    public void testRecoverPasswordEndpointWithSystemAdmin() throws Exception {
        this.mockMvc.
                perform(post("/recover_password").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "CLINIC_ADMIN")
    public void testRecoverPasswordEndpointWithClinicAdmin() throws Exception {
        this.mockMvc.
                perform(post("/recover_password").
                        header(HttpHeaders.CONTENT_TYPE, "application/json")).
                andExpect(status().isOk());
    }
}
