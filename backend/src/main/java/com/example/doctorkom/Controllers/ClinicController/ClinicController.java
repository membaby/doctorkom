package com.example.doctorkom.Controllers.ClinicController;

import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOMappers.TimeSlotMapper;
import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.DTOs.TimeSlotDTO;
import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.ClinicAdminRepository;
import com.example.doctorkom.Repositories.ClinicRepository;
import com.example.doctorkom.Services.ClinicServices.ClinicService;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clinic")
public class ClinicController {
    @Autowired
    ClinicRepository clinicRepository;
    @Autowired
    ClinicService clinicService;
    @Autowired
    ClinicMapper clinicMapper;
    @Autowired
    TimeSlotMapper timeSlotMapper;

    @PostMapping("/AddDoctor")
    public String AddDoctor(){
        return "Add Doctor";
    }
    @PostMapping("/DeleteDoctor")
    public String DeleteDoctor(){
        return "Delete Doctor";
    }
    @PostMapping("/EditClinicInfo")
    public String EditClinicInfo(@RequestBody ClinicDTO clinicDTO){
        Clinic clinic = clinicMapper.toEntity(clinicDTO);
        return clinicService.editClinicInfo(clinic);
    }
    @PostMapping("/AddTimeSlot")
    public String AddTimeSlot(@RequestBody TimeSlotDTO timeSlotDTO){
        TimeSlot timeSlot = timeSlotMapper.toEntity(timeSlotDTO);
        return clinicService.AddTimeSlot(timeSlot);
    }

    @PostMapping("/EditTimeSlot")
    public String EditTimeSlot(@RequestBody TimeSlotDTO timeSlotDTO){
        TimeSlot timeSlot = timeSlotMapper.toEntity(timeSlotDTO);
        return clinicService.EditTimeSlot(timeSlot);
    }
    @PostMapping("/RemoveTimeSlot")
    public String RemoveTimeSlot(@RequestBody TimeSlotDTO timeSlotDTO){
        TimeSlot timeSlot = timeSlotMapper.toEntity(timeSlotDTO);
        return clinicService.RemoveTimeSlot(timeSlot);
    }

    @PostMapping("/EditAppointment")
    public String EditAppointment(){
        return "Edit Appointment";
    }

    @PostMapping("/DeleteAppointment")
    public String DeleteAppointment(){
        return "Delete Appointment";
    }

    @GetMapping("/Appointments&TimeSlots")
    public Pair<List<Appointment>, List<TimeSlot>> AppointmentsAndTimeSlots(@RequestBody ClinicDTO clinicDTO){
        Clinic clinic = clinicMapper.toEntity(clinicDTO);
        return clinicService.GetAppointmentsAndTimeSlotsForClinic(clinic);
    }

    @GetMapping("/Doctors")
    public List<Doctor> Doctors(@RequestBody ClinicDTO clinicDTO){
        Clinic clinic = clinicMapper.toEntity(clinicDTO);
        return clinicService.GetDoctorsForClinic(clinic);
    }

    @GetMapping("/Test")
    public String Test(){
        Account account = Account.builder().
                username("ClinicAdmin").
                password("123456").
                email("ClinicAdmin@gmail.com").
                enabled(true).
                role(Role.CLINIC_ADMIN).
                build();
        ClinicAdmin clinicAdmin = ClinicAdmin.builder().account(account).build();
        Clinic clinic = Clinic.builder().admin(clinicAdmin).
                name("ClinicTest").
                address("Clinic-Test-Address").
                email("ClinicTest@gmail.com").
                mobilePhone("0123456789").
                landlinePhone("0123456789").
                build();
        clinicRepository.save(clinic);
        return "Clinic Test";
    }
}
