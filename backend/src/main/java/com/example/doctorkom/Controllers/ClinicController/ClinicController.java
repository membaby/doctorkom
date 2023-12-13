package com.example.doctorkom.Controllers.ClinicController;

import com.example.doctorkom.DTOMappers.AppointmentMapper;
import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOMappers.TimeSlotMapper;
import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.DTOs.ClinicDoctorDTO;
import com.example.doctorkom.DTOs.TimeSlotDTO;
import com.example.doctorkom.Entities.*;
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
    @Autowired
    AppointmentMapper appointmentMapper;

    @PostMapping("/AddDoctor")
    public String AddDoctor(@RequestBody ClinicDoctorDTO clinicDoctorDTO){
        Clinic clinic = clinicMapper.toEntity(clinicDoctorDTO.getClinic());
        String email = clinicDoctorDTO.getEmail();
        return clinicService.AddDoctorToClinic(email, clinic);
    }
    @PostMapping("/RemoveDoctor")
    public String RemoveDoctor(@RequestBody ClinicDoctorDTO clinicDoctorDTO){
        Clinic clinic = clinicMapper.toEntity(clinicDoctorDTO.getClinic());
        String email = clinicDoctorDTO.getEmail();
        return clinicService.RemoveDoctorFromClinic(email, clinic);
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
    public String EditAppointment(@RequestBody AppointmentDTO appointmentDTO){
        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        return clinicService.editAppointment(appointment);
    }

    @PostMapping("/RemoveAppointment")
    public String RemoveAppointment(@RequestBody AppointmentDTO appointmentDTO){
        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        return clinicService.removeAppointment(appointment);
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
    @GetMapping("/Clinic")
    public Clinic Clinic(@RequestBody int id){
        return clinicService.GetClinic(id);
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
