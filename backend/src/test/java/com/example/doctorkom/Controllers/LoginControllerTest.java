package com.example.doctorkom.Controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.doctorkom.DTOs.AccountDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {
    
    @Autowired
    private LoginController loginController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void applicationRunningTest(){
        //Confirm that the spring application is running
        assertTrue(loginController != null);
    }

    @Test
    public void loginReponseStructureTest(){
        //Send a login request with any credintials
        //Confirm response structure is correct
        AccountDTO account = AccountDTO.builder().username("a@b.c").password("12345678").build();
        LoginResponse response = restTemplate.postForObject("http://localhost:" + port + "/login", account, LoginResponse.class);
        assertTrue(response != null);
        if (response.success){
            switch (response.role){
                case PATIENT:
                    assertTrue(response.patient != null && response.doctor == null && response.systemAdmin == null && response.clinic == null);
                    break;
                case DOCTOR:
                    assertTrue(response.doctor != null && response.patient == null && response.systemAdmin == null && response.clinic == null);
                    break;
                case SYSTEM_ADMIN:
                    assertTrue(response.systemAdmin != null && response.patient == null && response.doctor == null && response.clinic == null);
                    break;
                case CLINIC_ADMIN:
                    assertTrue(response.clinic != null && response.patient == null && response.doctor == null && response.systemAdmin == null);
                    break;
            }
        }
    }

    @Test 
    public void invalidLogin() {
        //Send request with invalid account credientials
        //Confirm reponse.success is false
    }

    @Test
    public void validLogin() {
        //Send request with valid account credientials
        //Confirm reponse.success is true
    }

    @Test
    public void loginPatient(){
        //Send request with valid patient account credientials
        //Confirm reponse.success is true
        //Confirm reponse.type is patient
        //Confirm response.patient contains valid information
    }

    @Test
    public void loginDoctor(){
        //Send request with valid doctor account credientials
        //Confirm reponse.success is true
        //Confirm reponse.type is doctor
        //Confirm response.doctor contains valid information
    }

    @Test
    public void loginClinic(){
        //Send request with valid clinic account credientials
        //Confirm reponse.success is true
        //Confirm reponse.type is clinic admin
        //Confirm response.clinicAdmin contains valid information
    }

    @Test
    public void loginSystemAdmin(){
        //Send request with valid system admin account credientials
        //Confirm reponse.success is true
        //Confirm reponse.type is system admin
        //Confirm response.systemAdmin contains valid information
    }

}



