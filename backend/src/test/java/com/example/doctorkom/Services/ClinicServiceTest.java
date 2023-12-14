package com.example.doctorkom.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.ClinicRepository;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Services.ClinicServices.ClinicService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ClinicServiceTest {

    @Autowired
    ClinicService clinicService;
    @Autowired
    DoctorRepository doctorRepo;
    @Autowired
    ClinicRepository clinicRepo;
    

    @Test
    void testingH2()
    {
        Clinic clinic = buildTestClinic();
        clinicRepo.save(clinic);
        Clinic existingClinic = clinicRepo.findById(clinic.getId()).orElse(null);
        assertNotNull(existingClinic);
    }
    
    @Test
    void addValidDoctorToClinic() //Adds a valid doctor account to a clinic when it doesn't already work for this clinic
    {
        Doctor doctor = buildTestDoctor();
        Clinic clinic = buildTestClinic();
        doctorRepo.save(doctor);
        clinicRepo.save(clinic);
        String str = clinicService.AddDoctorToClinic(doctor.getSystemUser().getAccount().getEmail(), clinic);
        assertEquals("Doctor added successfully", str);
        
        //Check that this doctor-clinic pair exist in the Works_For table.
        List<Doctor> doctors = clinic.getDoctors();
        List<Clinic> clinics = doctor.getClinics();
        assertTrue(doctors.contains(doctor));
        assertTrue(clinics.contains(clinic));
    }
    
    @Test
    void addValidPreAddedDoctorToClinic() //Adds a valid doctor account to a clinic when it already works for the clinic
    {
        Doctor doctor = buildTestDoctor();
        Clinic clinic = buildTestClinic();
        doctorRepo.save(doctor);
        clinicRepo.save(clinic);
        String str = clinicService.AddDoctorToClinic(doctor.getSystemUser().getAccount().getEmail(), clinic);
        assertEquals("Doctor added successfully", str);
        str = clinicService.AddDoctorToClinic(doctor.getSystemUser().getAccount().getEmail(), clinic);
        assertEquals("Doctor already in the clinic", str);

        //Check that this doctor-clinic pair exist in the Works_For table.
        List<Doctor> doctors = clinic.getDoctors();
        List<Clinic> clinics = doctor.getClinics();
        assertTrue(doctors.contains(doctor));
        assertTrue(clinics.contains(clinic));
    }
    
    @Test
    void addInvalidDoctorToClinic() //Adds an invalid doctor account to a clinic
    {
        Doctor doctor = buildTestDoctor();
        Clinic clinic = buildTestClinic();
        doctorRepo.save(doctor);
        clinicRepo.save(clinic);
        String str = clinicService.AddDoctorToClinic("a@b.c", clinic);
        assertEquals("Doctor not found", str); 
        //Check the clinic has no doctors
        List<Doctor> doctors = clinic.getDoctors();
        assertTrue(doctors.isEmpty());
    }
    
    @Test
    void addValidDoctorToClinic2() //Adds a valid doctor account to 2 different clinics
    {
        Doctor doctor = buildTestDoctor();
        Clinic clinic = buildTestClinic();
        Clinic clinic2 = buildTestClinic();
        Account c2Acc = clinic2.getAdmin().getAccount();
        c2Acc.setEmail("clinic@g-mail.com");
        c2Acc.setUsername("null");
        doctorRepo.save(doctor);
        clinicRepo.save(clinic);
        clinicRepo.save(clinic2);
        String str = clinicService.AddDoctorToClinic(doctor.getSystemUser().getAccount().getEmail(), clinic);
        assertEquals("Doctor added successfully", str); 
        str = clinicService.AddDoctorToClinic(doctor.getSystemUser().getAccount().getEmail(), clinic2);
        assertEquals("Doctor added successfully", str);
        //Check the doctor exists in each clinic and both clinics exist in the doctor
        List<Doctor> doctors1 = clinic.getDoctors();
        List<Doctor> doctors2 = clinic2.getDoctors();
        List<Clinic> clinics = doctor.getClinics(); 
        assertTrue(doctors1.contains(doctor));
        assertTrue(doctors2.contains(doctor));
        assertTrue(clinics.contains(clinic));
        assertTrue(clinics.contains(clinic2));
    }

    @Test
    void removeExistingDoctorFromClinic() //Removes a doctor from a clinic when it already works for this clinic
    {
        assertTrue(true);
    }

    @Test
    void removeNonExistingDoctorFromClinic() //Removes a doctor from a clinic when it doesn't work for that clinic
    {
        assertTrue(true);
    }

    @Test
    void removeNonExistingDoctorFromClinic2() //Removes a doctor from a clinic when it doesn't work for that clinic but works for another one.
    {
        assertTrue(true);
    }

    @Test
    void AddTimeSlot_doesntConflict_withTimeslots(){
        assertTrue(true);
    }

    @Test
    void AddTimeSlot_conflict_withTimeslots(){
        assertTrue(true);
    }

    @Test
    void AddTimeSlot_doesntConflict_withDoctor(){
        assertTrue(true);
    }

    @Test
    void AddTimeSlot_conflict_withDoctor(){
        assertTrue(true);
    }

    @Test
    void EditTimeSlot_conflict_withDoctor(){
        assertTrue(true);
    }
    @Test
    void EditTimeSlot_doesntConflict_withTimeslots(){
        assertTrue(true);
    }

    @Test
    void EditTimeSlot_conflict_withTimeslots(){
        assertTrue(true);
    }

    @Test
    void EditTimeSlot_doesntConflict_withDoctor(){
        assertTrue(true);
    }
    @Test
    void RemoveTimeSlot(){
        assertTrue(true);
    }

    @Test
    void removeAppointment(){
        assertTrue(true);
    }

    @Test
    void editAppointment_doesntConflict(){
        assertTrue(true);
    }

    @Test
    void editAppointment_conflict(){
        assertTrue(true);
    }

    @Test
    void editClinicInfo(){
        assertTrue(true);
    }


    Clinic buildTestClinic(){
        Account account = Account.builder().
        email("swe.test.system@gmail.com").
        username("clinic-admin").
        role(Role.CLINIC_ADMIN).
        password("123").build();
        ClinicAdmin clinicAdmin = ClinicAdmin.builder().account(account).build();
        Clinic clinic = Clinic.builder().admin(clinicAdmin).
        name("Test clinic").
        address("asdfasdf").
        email("Contact.Us@gmail.com").
        mobilePhone("9879879").
        landlinePhone("97653264").build();
        return clinic;
    }

    Doctor buildTestDoctor(){
        Account account = Account.builder().
        email("swe.test.doctor@gmail.com").
        password("123").
        username("test-doctor").
        role(Role.DOCTOR).build();
        SystemUser user = SystemUser.builder().
        account(account).
        firstName("Test").
        lastName("Doctor").
        mobilePhone("123456789").
        landlinePhone("123456789").
        address("asdfasdf").
        birthdate(Date.valueOf("1999-01-01")).
        gender(Gender.FEMALE).build();
        Doctor doctor = Doctor.builder().systemUser(user).
        specialty(DoctorSpecialty.ANESTHESIOLOGIST).
        title(DoctorTitle.CONSULTANT)
        .build();
        return doctor;
    }

}
