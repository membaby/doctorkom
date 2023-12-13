package com.example.doctorkom.Services.ClinicServices;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClinicService {

    private ClinicRepository clinicRepository;
    private DoctorRepository doctorRepository;
    private TimeSlotRepository timeSlotRepository;
    private AppointmentRepository appointmentRepository;
    private AccountRepository accountRepository;
    @Autowired
    public void ClinicService(ClinicRepository clinicRepository,
                              DoctorRepository doctorRepository,
                              TimeSlotRepository timeSlotRepository,
                              AppointmentRepository appointmentRepository,
                              AccountRepository accountRepository) {
        this.doctorRepository = doctorRepository;
        this.clinicRepository = clinicRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.appointmentRepository = appointmentRepository;
        this.accountRepository = accountRepository;
    }

    public String editClinicInfo(Clinic clinic){
        Optional<Clinic> existingClinic = clinicRepository.findById(clinic.getId());
        if(existingClinic.isPresent()){
            clinic.setDoctors(existingClinic.get().getDoctors());
            clinicRepository.save(clinic);
            return "Clinic edited";
        }
        else{
            return "Clinic Doesn't exist";
        }
    }
    public String AddDoctorToClinic(String doctorEmail,Clinic clinic){
        Optional<Clinic> existingClinic = clinicRepository.findById(clinic.getId());
        if(existingClinic.isPresent()){
            Account doctorAccount = accountRepository.findByEmail(doctorEmail).orElse(null);
            Doctor doctor = doctorRepository.findById(doctorAccount.getId()).orElse(null);
            if(doctor != null){
                //check if doctor is already in the clinic
                clinic = existingClinic.get();
                List<Doctor> clinicDoctors = clinic.getDoctors();
                for(Doctor doctor1 : clinicDoctors){
                    if(Objects.equals(doctor1.getId(), doctor.getId())){
                        return "Doctor already in the clinic";
                    }
                }
                clinicDoctors.add(doctor);
                clinic.setDoctors(clinicDoctors);
                clinicRepository.save(clinic);
                return "Doctor added successfully";
            }
            else{
                //check if doctor is in the database or in the clinic
                return "Doctor not found";
            }
        }
        else{
            return "Clinic not found";
        }
    }

    public String RemoveDoctorFromClinic(String doctorEmail,Clinic clinic){
        Optional<Clinic> existingClinic = clinicRepository.findById(clinic.getId());
        if(existingClinic.isPresent()){
            Account doctorAccount = accountRepository.findByEmail(doctorEmail).orElse(null);
            Doctor doctor = doctorRepository.findById(doctorAccount.getId()).orElse(null);
            if(doctor != null){
                clinic = existingClinic.get();
                List<Doctor> clinicDoctors = clinic.getDoctors();
                for(Doctor doctor1 : clinicDoctors){
                    if(Objects.equals(doctor1.getId(), doctor.getId())){
                        clinicDoctors.remove(doctor1);
                        clinic.setDoctors(clinicDoctors);
                        clinicRepository.save(clinic);
                        return "Doctor removed successfully";
                    }
                }
                return "Doctor not found in the clinic";
            }
            else{
                return "Doctor not found";
            }
        }
        else{
            return "Clinic not found";
        }
    }

    public String AddTimeSlot(TimeSlot timeSlot){
        Doctor doctor = timeSlot.getDoctor();
        Clinic clinic = timeSlot.getClinic();
        int doctorId = doctor.getId();
        int clinicId = clinic.getId();
        Time startTime = timeSlot.getStartTime();
        Time endTime = timeSlot.getEndTime();

        if(doctorRepository.findById(doctorId).isPresent()){
            if(clinicRepository.findById(clinicId).isPresent()){
                //check if time slot collides with another time slot for the same doctor and clinic
                List<TimeSlot> timeSlots = timeSlotRepository.findByDoctorIdAndDate(doctorId,timeSlot.getDate());
                List<TimeSlot> timeSlots2 = timeSlotRepository.findByClinicIdAndDate(clinicId,timeSlot.getDate());
                for(TimeSlot timeSlot1 : timeSlots){
                    if(timeSlot1.getStartTime().before(endTime) || timeSlot1.getEndTime().after(startTime)){
                        return "Time slot collides doctor";
                    }
                }
                for(TimeSlot timeSlot1 : timeSlots2){
                    if(timeSlot1.getStartTime().before(endTime) || timeSlot1.getEndTime().after(startTime)){
                        return "Time slot collides clinic";
                    }
                }
                timeSlotRepository.save(timeSlot);
                return "Time slot added successfully";
            }
            else{
                return "Clinic not found";
            }
        }
        else{
            return "Doctor not found";
        }
    }
    public String EditTimeSlot(TimeSlot timeSlot){
        Doctor doctor = timeSlot.getDoctor();
        Clinic clinic = timeSlot.getClinic();
        int doctorId = doctor.getId();
        int clinicId = clinic.getId();
        Time startTime = timeSlot.getStartTime();
        Time endTime = timeSlot.getEndTime();

        if(doctorRepository.findById(doctorId).isPresent()){
            if(clinicRepository.findById(clinicId).isPresent()){
                //check if time slot collides with another time slot for the same doctor and clinic
                List<TimeSlot> timeSlots = timeSlotRepository.findByDoctorIdAndDate(doctorId,timeSlot.getDate());
                List<TimeSlot> timeSlots2 = timeSlotRepository.findByClinicIdAndDate(clinicId,timeSlot.getDate());
                for(TimeSlot timeSlot1 : timeSlots){
                    if(timeSlot1.getStartTime().before(endTime) || timeSlot1.getEndTime().after(startTime)){
                        return "Time slot collides with another time slot for the same doctor";
                    }
                }
                for(TimeSlot timeSlot1 : timeSlots2){
                    if(timeSlot1.getStartTime().before(endTime) || timeSlot1.getEndTime().after(startTime)){
                        return "Time slot collides with another time slot for the same clinic";
                    }
                }
                timeSlotRepository.save(timeSlot);
                //check if time slot is reserved then notify the patient
                return "Time slot edited successfully";
            }
            else{
                return "Clinic not found";
            }
        }
        else{
            return "Doctor not found";
        }
    }
    public String RemoveTimeSlot(TimeSlot timeSlot){
        TimeSlotId timeSlotId = timeSlot.getId();
        TimeSlot timeSlot1 = timeSlotRepository.findById(timeSlotId).orElse(null);
        if(timeSlot1 != null){
            timeSlotRepository.delete(timeSlot1);
            return "Time slot removed successfully";
        }
        else{
            return "Time slot not found";
        }
    }

    public String editAppointment(Appointment appointment){
        AppointmentId appointmentId = appointment.getId();
        Appointment oldAppointment = appointmentRepository.findById(appointmentId).orElse(null);
        if (oldAppointment != null){
            TimeSlot newTimeSlot = timeSlotRepository.findById(appointment.getTimeSlot().getId()).orElse(null);
            if (newTimeSlot != null){
                if (newTimeSlot.getReserved()){
                    return "Time slot is Taken";
                }
                else{
                    appointmentRepository.save(appointment);
                    //notify the patient
                    return "Appointment edited successfully";
                }
            }
            else {
                return "Time slot doesn't exist";
            }
        }
        else{
            return "Appointment Doesn't exist";
        }
    }
    public String removeAppointment(Appointment appointment){
        AppointmentId appointmentId = appointment.getId();
        Appointment oldAppointment = appointmentRepository.findById(appointmentId).orElse(null);
        if (oldAppointment != null){
            appointmentRepository.delete(oldAppointment);
            //notify the patient
            return "Appointment removed successfully";
        }
        else{
            return "Appointment Doesn't exist";
        }
    }

    public Pair<List<Appointment>, List<TimeSlot>> GetAppointmentsAndTimeSlotsForClinic(Clinic clinic){
        if (clinicRepository.findById(clinic.getId()).isEmpty()){
            return null;
        }
        List<TimeSlot> timeSlots = timeSlotRepository.findByClinic(clinic);
        //for each time slot get the appointment
        List<Appointment> appointments = new ArrayList<>();
        for (TimeSlot timeSlot : timeSlots){
            Appointment appointment = appointmentRepository.findByTimeSlot(timeSlot);
            if (appointment != null){
                appointments.add(appointment);
            }
        }
        return new Pair<>(appointments,timeSlots);
    }

    public List<Doctor> GetDoctorsForClinic(Clinic clinic) {
        if (clinicRepository.findById(clinic.getId()).isEmpty()){
            return null;
        }
        List<Doctor> doctors = clinic.getDoctors();
        return new ArrayList<>(doctors);
    }


    public Clinic GetClinic(int id) {
        return clinicRepository.findById(id).orElse(null);
    }
}
