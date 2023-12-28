package com.example.doctorkom.Controllers;

import com.example.doctorkom.Controllers.ClinicController.ClinicController;
import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOMappers.TimeSlotMapper;
import com.example.doctorkom.DTOs.*;
import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.TimeSlot;
import com.example.doctorkom.Services.ClinicServices.ClinicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClinicControllerTest {
    @Mock
    private ClinicController clinicController;
    @Mock
    private ClinicMapper clinicMapper;

    @Mock
    private ClinicService clinicService;

    @Mock
    private TimeSlotMapper timeSlotMapper;
    @Mock
    private DoctorMapper doctorMapper;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void editClinicInfo(){
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.editClinicInfo(clinicTest)).thenReturn("Clinic edited successfully");

        when(clinicController.EditClinicInfo(clinicDTOTest)).thenAnswer(invocation -> {
            ClinicDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg);
            return clinicService.editClinicInfo(clinic);
        });

        // Invoke the actual method being tested
        String response = clinicController.EditClinicInfo(clinicDTOTest);

        // Verify the result
        assertEquals("Clinic edited successfully", response);

        // Verify the calls
        verify(clinicController, times(1)).EditClinicInfo(clinicDTOTest);
        verify(clinicService, times(1)).editClinicInfo(clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }

    @Test
    void getDoctors(){
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();
        DoctorDTO doctorDTOTest = DoctorDTO.builder().build();
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(Doctor.builder().build());
        doctors.add(Doctor.builder().build());
        doctors.add(Doctor.builder().build());
        List<DoctorDTO> doctorDTOSr = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDTOSr.add(doctorDTOTest);
        }


        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.GetDoctorsForClinic(clinicTest)).thenReturn(doctors);
        when(doctorMapper.toDto(any())).thenReturn(doctorDTOTest);

        when(clinicController.Doctors(clinicDTOTest)).thenAnswer(invocation -> {
            ClinicDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg);
            List<Doctor> doctorList = clinicService.GetDoctorsForClinic(clinic);
            List<DoctorDTO> doctorDTOS = new ArrayList<>();
            for (Doctor doctor : doctorList) {
                doctorDTOS.add(doctorMapper.toDto(doctor));
            }
            return doctorDTOS;
        });

        // Invoke the actual method being tested
        List<DoctorDTO> response = clinicController.Doctors(clinicDTOTest);

        // Verify the result
        assertEquals(doctorDTOSr, response);

        // Verify the calls
        verify(clinicController, times(1)).Doctors(clinicDTOTest);
        verify(clinicService, times(1)).GetDoctorsForClinic(clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
        verify(doctorMapper, times(doctors.size())).toDto(any());
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

    @Test
    void EditClinicInfo_ClinicExist() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.editClinicInfo(clinicTest)).thenReturn("Clinic edited successfully");

        when(clinicController.EditClinicInfo(clinicDTOTest)).thenAnswer(invocation -> {
            ClinicDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg);
            return clinicService.editClinicInfo(clinic);
        });

        // Invoke the actual method being tested
        String response = clinicController.EditClinicInfo(clinicDTOTest);

        // Verify the result
        assertEquals("Clinic edited successfully", response);

        // Verify the calls
        verify(clinicController, times(1)).EditClinicInfo(clinicDTOTest);
        verify(clinicService, times(1)).editClinicInfo(clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }

    @Test
    void EditClinicInfo_ClinicNotExist() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();

        when(clinicMapper.toEntity(clinicDTOTest)).thenReturn(clinicTest);
        when(clinicService.editClinicInfo(clinicTest)).thenReturn("Clinic not found");

        when(clinicController.EditClinicInfo(clinicDTOTest)).thenAnswer(invocation -> {
            ClinicDTO arg = invocation.getArgument(0);
            Clinic clinic = clinicMapper.toEntity(arg);
            return clinicService.editClinicInfo(clinic);
        });

        // Invoke the actual method being tested
        String response = clinicController.EditClinicInfo(clinicDTOTest);

        // Verify the result
        assertEquals("Clinic not found", response);

        // Verify the calls
        verify(clinicController, times(1)).EditClinicInfo(clinicDTOTest);
        verify(clinicService, times(1)).editClinicInfo(clinicTest);
        verify(clinicMapper, times(1)).toEntity(clinicDTOTest);
    }


    @Test
    void AddTimeSlot_TimeSlotAvailable() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        TimeSlotDTO timeSlotDTOTest = TimeSlotDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();
        TimeSlot timeSlotTest = TimeSlot.builder().build();

        when(timeSlotMapper.toEntity(timeSlotDTOTest)).thenReturn(timeSlotTest);
        when(clinicService.AddTimeSlot(timeSlotTest)).thenReturn("Time slot added successfully");

        when(clinicController.AddTimeSlot(timeSlotDTOTest)).thenAnswer(invocation -> {
            TimeSlotDTO arg = invocation.getArgument(0);
            TimeSlot timeSlot = timeSlotMapper.toEntity(arg);
            return clinicService.AddTimeSlot(timeSlot);
        });

        // Invoke the actual method being tested
        String response = clinicController.AddTimeSlot(timeSlotDTOTest);

        // Verify the result
        assertEquals("Time slot added successfully", response);

        // Verify the calls
        verify(clinicController, times(1)).AddTimeSlot(timeSlotDTOTest);
        verify(clinicService, times(1)).AddTimeSlot(timeSlotTest);
        verify(timeSlotMapper, times(1)).toEntity(timeSlotDTOTest);
    }
    
    @Test
    void AddTimeSlot_TimeSlotCollidesWithDoctor() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        TimeSlotDTO timeSlotDTOTest = TimeSlotDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();
        TimeSlot timeSlotTest = TimeSlot.builder().build();

        when(timeSlotMapper.toEntity(timeSlotDTOTest)).thenReturn(timeSlotTest);
        when(clinicService.AddTimeSlot(timeSlotTest)).thenReturn("Time slot Collides with doctor");

        when(clinicController.AddTimeSlot(timeSlotDTOTest)).thenAnswer(invocation -> {
            TimeSlotDTO arg = invocation.getArgument(0);
            TimeSlot timeSlot = timeSlotMapper.toEntity(arg);
            return clinicService.AddTimeSlot(timeSlot);
        });

        // Invoke the actual method being tested
        String response = clinicController.AddTimeSlot(timeSlotDTOTest);

        // Verify the result
        assertEquals("Time slot Collides with doctor", response);

        // Verify the calls
        verify(clinicController, times(1)).AddTimeSlot(timeSlotDTOTest);
        verify(clinicService, times(1)).AddTimeSlot(timeSlotTest);
        verify(timeSlotMapper, times(1)).toEntity(timeSlotDTOTest);
    }

    @Test
    void AddTimeSlot_TimeSlotCollidesWithAnotherTimeSlot() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        TimeSlotDTO timeSlotDTOTest = TimeSlotDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();
        TimeSlot timeSlotTest = TimeSlot.builder().build();

        when(timeSlotMapper.toEntity(timeSlotDTOTest)).thenReturn(timeSlotTest);
        when(clinicService.AddTimeSlot(timeSlotTest)).thenReturn("Time slot Collides with another time slot");

        when(clinicController.AddTimeSlot(timeSlotDTOTest)).thenAnswer(invocation -> {
            TimeSlotDTO arg = invocation.getArgument(0);
            TimeSlot timeSlot = timeSlotMapper.toEntity(arg);
            return clinicService.AddTimeSlot(timeSlot);
        });

        // Invoke the actual method being tested
        String response = clinicController.AddTimeSlot(timeSlotDTOTest);

        // Verify the result
        assertEquals("Time slot Collides with another time slot", response);

        // Verify the calls
        verify(clinicController, times(1)).AddTimeSlot(timeSlotDTOTest);
        verify(clinicService, times(1)).AddTimeSlot(timeSlotTest);
        verify(timeSlotMapper, times(1)).toEntity(timeSlotDTOTest);
    }

    @Test
    void RemoveTimeSlot_TimeSlotExist() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        TimeSlotDTO timeSlotDTOTest = TimeSlotDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();
        TimeSlot timeSlotTest = TimeSlot.builder().build();

        when(timeSlotMapper.toEntity(timeSlotDTOTest)).thenReturn(timeSlotTest);
        when(clinicService.RemoveTimeSlot(timeSlotTest)).thenReturn("Time slot removed successfully");

        when(clinicController.RemoveTimeSlot(timeSlotDTOTest)).thenAnswer(invocation -> {
            TimeSlotDTO arg = invocation.getArgument(0);
            TimeSlot timeSlot = timeSlotMapper.toEntity(arg);
            return clinicService.RemoveTimeSlot(timeSlot);
        });

        // Invoke the actual method being tested
        String response = clinicController.RemoveTimeSlot(timeSlotDTOTest);

        // Verify the result
        assertEquals("Time slot removed successfully", response);

        // Verify the calls
        verify(clinicController, times(1)).RemoveTimeSlot(timeSlotDTOTest);
        verify(clinicService, times(1)).RemoveTimeSlot(timeSlotTest);
        verify(timeSlotMapper, times(1)).toEntity(timeSlotDTOTest);
    }

    @Test
    void RemoveTimeSlot_TimeSlotNotExist() {
        ClinicDTO clinicDTOTest = ClinicDTOBuilder();
        TimeSlotDTO timeSlotDTOTest = TimeSlotDTOBuilder();
        Clinic clinicTest = Clinic.builder().build();
        TimeSlot timeSlotTest = TimeSlot.builder().build();

        when(timeSlotMapper.toEntity(timeSlotDTOTest)).thenReturn(timeSlotTest);
        when(clinicService.RemoveTimeSlot(timeSlotTest)).thenReturn("Time slot not found");

        when(clinicController.RemoveTimeSlot(timeSlotDTOTest)).thenAnswer(invocation -> {
            TimeSlotDTO arg = invocation.getArgument(0);
            TimeSlot timeSlot = timeSlotMapper.toEntity(arg);
            return clinicService.RemoveTimeSlot(timeSlot);
        });

        // Invoke the actual method being tested
        String response = clinicController.RemoveTimeSlot(timeSlotDTOTest);

        // Verify the result
        assertEquals("Time slot not found", response);

        // Verify the calls
        verify(clinicController, times(1)).RemoveTimeSlot(timeSlotDTOTest);
        verify(clinicService, times(1)).RemoveTimeSlot(timeSlotTest);
        verify(timeSlotMapper, times(1)).toEntity(timeSlotDTOTest);
    }



    private TimeSlotDTO TimeSlotDTOBuilder() {
        TimeSlotDTO timeSlotDTO = TimeSlotDTO.builder().build();
        return timeSlotDTO;
    }

    private ClinicDTO ClinicDTOBuilder() {
        AccountDTO accountDTO = AccountDTO.builder().username("a@b.c").password("12345678").id(10).build();
        ClinicAdminDTO clinicAdminDTO = ClinicAdminDTO.builder().account(accountDTO).id(10).build();
        ClinicDTO clinicDTO = ClinicDTO.builder().admin(clinicAdminDTO).name("clinicmock").id(10).build();
        return clinicDTO;
    }
}
