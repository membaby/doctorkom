package com.example.doctorkom.Controllers.ClinicController;

import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.ClinicAdmin;
import com.example.doctorkom.Entities.Role;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.ClinicAdminRepository;
import com.example.doctorkom.Repositories.ClinicRepository;
import com.example.doctorkom.Services.ClinicServices.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Clinic")
public class ClinicController {
    @Autowired
    ClinicRepository clinicRepository;
    @Autowired
    ClinicService clinicService;
    @Autowired
    ClinicMapper clinicMapper;

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
    public String AddTimeSlot(){
        return "Add Time Slot";
    }

    @PostMapping("/EditTimeSlot")
    public String EditTimeSlot(){
        return "Edit Time Slot";
    }
    @PostMapping("/DeleteTimeSlot")
    public String DeleteTimeSlot(){
        return "Delete Time Slot";
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
    public String AppointmentsAndTimeSlots(){
        return "Appointments And Time Slots";
    }

    @GetMapping("/Doctors")
    public String Doctors(){
        return "Doctors";
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
