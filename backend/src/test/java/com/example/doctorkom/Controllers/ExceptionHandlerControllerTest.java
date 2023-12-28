package com.example.doctorkom.Controllers;

import com.example.doctorkom.Exceptions.DoctorExceptions.DoctorNotFoundException;
import com.example.doctorkom.Exceptions.PatientExceptions.PatientNotFoundException;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
class ExceptionHandlerControllerTest {
    private MockMvc mockMvc;

    @Mock
    private PatientController patientController;

    @Mock
    private DoctorController doctorController;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(patientController, doctorController)
                .setControllerAdvice(new ExceptionHandlerController())
                .build();
    }

    @Test
    public void handleDefaultExceptionWithPatientController() throws Exception {
        int userId = 0;
        int pageCount = 0;

        when(patientController.getPatientAppointments(userId, pageCount)).thenThrow(new PatientNotFoundException());

        mockMvc.perform(get("/patient/appointments/" + userId + "/" + pageCount))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void handleExceptionWithPatientController() throws Exception {
        int pageCount = 0;

        mockMvc.perform(get("/patient/appointments/" + "someNonSense" + "/" + pageCount))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void handleDefaultExceptionWithDoctorController() throws Exception {
        int userId = 0;
        int pageCount = 0;

        when(doctorController.getDoctorAppointments(userId)).thenThrow(new DoctorNotFoundException());

        mockMvc.perform(get("/doctor/appointments/" + userId + "/" + pageCount))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void handleExceptionWithDoctorController() throws Exception {
        mockMvc.perform(get("/doctor/appointments?doctorId=" + "someNonSense"))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }
}