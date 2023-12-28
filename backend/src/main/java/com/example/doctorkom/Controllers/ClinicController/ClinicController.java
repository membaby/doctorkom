package com.example.doctorkom.Controllers.ClinicController;

import com.example.doctorkom.DTOMappers.AppointmentMapper;
import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOMappers.TimeSlotMapper;
import com.example.doctorkom.DTOs.*;
import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.ClinicRepository;
import com.example.doctorkom.Services.ClinicServices.ClinicService;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Clinic")
public class ClinicController {

    @Autowired
    ClinicService clinicService;
    @Autowired
    ClinicMapper clinicMapper;
    @Autowired
    TimeSlotMapper timeSlotMapper;
    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    DoctorMapper doctorMapper;

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

    @PostMapping("/Appointments&TimeSlots")
    public List<List<?>> AppointmentsAndTimeSlots(@RequestBody ClinicDTO clinicDTO){
        Clinic clinic = clinicMapper.toEntity(clinicDTO);
        List<List<?>> appointmentsAndTimeSlots = new ArrayList<>();

        List<AppointmentDTO> appointments = clinicService.getAppointmentsForClinic(clinic);
        List<TimeSlotDTO> timeslots = clinicService.getTimeSlotsForClinic(clinic);

        appointmentsAndTimeSlots.add(appointments);
        appointmentsAndTimeSlots.add(timeslots);

        return appointmentsAndTimeSlots;
    }

    @PostMapping("/Doctors")
    public List<DoctorDTO> Doctors(@RequestBody ClinicDTO clinicDTO){
        Clinic clinic = clinicMapper.toEntity(clinicDTO);
        List<Doctor> doctors = clinicService.GetDoctorsForClinic(clinic);
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDTOS.add(doctorMapper.toDto(doctor));
        }
        return doctorDTOS;
    }
    @PostMapping("/Clinic")
    public ClinicDTO Clinic(@RequestBody int id){
        System.out.println(id);
        return clinicMapper.toDto(clinicService.GetClinic(id));
    }

    /*@GetMapping("/Test")
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
    }*/
}
