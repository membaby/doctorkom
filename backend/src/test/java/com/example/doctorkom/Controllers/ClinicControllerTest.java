package com.example.doctorkom.Controllers;

import com.example.doctorkom.Controllers.ClinicController.ClinicController;
import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.ClinicAdminDTO;
import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.DTOs.ClinicDoctorDTO;
import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Services.ClinicServices.ClinicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClinicControllerTest {
    @Mock
    private ClinicController clinicController;
    @Mock
    private ClinicMapper clinicMapper;

    @Mock
    private ClinicService clinicService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void AddDoctorToClinic_DoctorExist() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        String doctorEmail = "doc@tets.com";
        ClinicDoctorDTO clinicDoctorDTO = ClinicDoctorDTO.builder().clinic(clinicDTOTest).email(doctorEmail).build();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.AddDoctorToClinic(doctorEmail, clinicTest)).thenReturn("Doctor added successfully");

        when(clinicController.AddDoctor(clinicDoctorDTO)).thenAnswer(invocation -> {
            ClinicDoctorDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg.getClinic());
            String email = arg.getEmail();
            return clinicService.AddDoctorToClinic(email, clinic);
        });


        // Invoke the actual method being tested
        String response = clinicController.AddDoctor(clinicDoctorDTO);

        // Verify the result
        assertEquals("Doctor added successfully", response);

        // Verify the calls
        verify(clinicController, times(1)).AddDoctor(clinicDoctorDTO);
        verify(clinicService, times(1)).AddDoctorToClinic(doctorEmail, clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }

    @Test
    void AddDoctorToClinic_DoctorNotExist() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        String doctorEmail = "doc@tets.com";
        ClinicDoctorDTO clinicDoctorDTO = ClinicDoctorDTO.builder().clinic(clinicDTOTest).email(doctorEmail).build();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.AddDoctorToClinic(doctorEmail, clinicTest)).thenReturn("Doctor not found");

        when(clinicController.AddDoctor(clinicDoctorDTO)).thenAnswer(invocation -> {
            ClinicDoctorDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg.getClinic());
            String email = arg.getEmail();
            return clinicService.AddDoctorToClinic(email, clinic);
        });

        // Invoke the actual method being tested
        String response = clinicController.AddDoctor(clinicDoctorDTO);

        // Verify the result
        assertEquals("Doctor not found", response);

        // Verify the calls
        verify(clinicController, times(1)).AddDoctor(clinicDoctorDTO);
        verify(clinicService, times(1)).AddDoctorToClinic(doctorEmail, clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }

    @Test
    void AddDoctorToClinic_DoctorAlreadyExist(){
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        String doctorEmail = "doc@tets.com";
        ClinicDoctorDTO clinicDoctorDTO = ClinicDoctorDTO.builder().clinic(clinicDTOTest).email(doctorEmail).build();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.AddDoctorToClinic(doctorEmail, clinicTest)).thenReturn("Doctor already exist");

        when(clinicController.AddDoctor(clinicDoctorDTO)).thenAnswer(invocation -> {
            ClinicDoctorDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg.getClinic());
            String email = arg.getEmail();
            return clinicService.AddDoctorToClinic(email, clinic);
        });

        // Invoke the actual method being tested
        String response = clinicController.AddDoctor(clinicDoctorDTO);

        // Verify the result
        assertEquals("Doctor already exist", response);

        // Verify the calls
        verify(clinicController, times(1)).AddDoctor(clinicDoctorDTO);
        verify(clinicService, times(1)).AddDoctorToClinic(doctorEmail, clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }

    @Test
    void RemoveDoctorFromClinic_DoctorExist() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        String doctorEmail = "doc@tets.com";
        ClinicDoctorDTO clinicDoctorDTO = ClinicDoctorDTO.builder().clinic(clinicDTOTest).email(doctorEmail).build();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.RemoveDoctorFromClinic(doctorEmail, clinicTest)).thenReturn("Doctor removed successfully");

        when(clinicController.RemoveDoctor(clinicDoctorDTO)).thenAnswer(invocation -> {
            ClinicDoctorDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg.getClinic());
            String email = arg.getEmail();
            return clinicService.RemoveDoctorFromClinic(email, clinic);
        });

        // Invoke the actual method being tested
        String response = clinicController.RemoveDoctor(clinicDoctorDTO);

        // Verify the result
        assertEquals("Doctor removed successfully", response);

        // Verify the calls
        verify(clinicController, times(1)).RemoveDoctor(clinicDoctorDTO);
        verify(clinicService, times(1)).RemoveDoctorFromClinic(doctorEmail, clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }

    @Test
    void RemoveDoctorFromClinic_DoctorNotExist() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        String doctorEmail = "doc@tets.com";
        ClinicDoctorDTO clinicDoctorDTO = ClinicDoctorDTO.builder().clinic(clinicDTOTest).email(doctorEmail).build();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.RemoveDoctorFromClinic(doctorEmail, clinicTest)).thenReturn("Doctor not found");

        when(clinicController.RemoveDoctor(clinicDoctorDTO)).thenAnswer(invocation -> {
            ClinicDoctorDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg.getClinic());
            String email = arg.getEmail();
            return clinicService.RemoveDoctorFromClinic(email, clinic);
        });

        // Invoke the actual method being tested
        String response = clinicController.RemoveDoctor(clinicDoctorDTO);

        // Verify the result
        assertEquals("Doctor not found", response);

        // Verify the calls
        verify(clinicController, times(1)).RemoveDoctor(clinicDoctorDTO);
        verify(clinicService, times(1)).RemoveDoctorFromClinic(doctorEmail, clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }

    @Test
    void RemoveDoctorFromClinic_DoctorNotInClinic(){
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        String doctorEmail = "doc@tets.com";
        ClinicDoctorDTO clinicDoctorDTO = ClinicDoctorDTO.builder().clinic(clinicDTOTest).email(doctorEmail).build();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.RemoveDoctorFromClinic(doctorEmail, clinicTest)).thenReturn("Doctor not in clinic");

        when(clinicController.RemoveDoctor(clinicDoctorDTO)).thenAnswer(invocation -> {
            ClinicDoctorDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg.getClinic());
            String email = arg.getEmail();
            return clinicService.RemoveDoctorFromClinic(email, clinic);
        });

        // Invoke the actual method being tested
        String response = clinicController.RemoveDoctor(clinicDoctorDTO);

        // Verify the result
        assertEquals("Doctor not in clinic", response);

        // Verify the calls
        verify(clinicController, times(1)).RemoveDoctor(clinicDoctorDTO);
        verify(clinicService, times(1)).RemoveDoctorFromClinic(doctorEmail, clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }

    private ClinicDTO ClinicDTOBuilder() {
        AccountDTO accountDTO = AccountDTO.builder().username("a@b.c").password("12345678").id(10).build();
        ClinicAdminDTO clinicAdminDTO = ClinicAdminDTO.builder().account(accountDTO).id(10).build();
        ClinicDTO clinicDTO = ClinicDTO.builder().admin(clinicAdminDTO).name("clinicmock").id(10).build();
        return clinicDTO;
    }
}
