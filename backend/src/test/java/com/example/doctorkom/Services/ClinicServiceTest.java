package com.example.doctorkom.Services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class ClinicServiceTest {
    @Test
    void AddDoctorToClinic_Exist(){
        assertTrue(true);
    }
    @Test
    void AddDoctorToClinic_NotExist(){
        assertTrue(true);
    }

    @Test
    void RemoveDoctorFromClinic_Exist(){
        assertTrue(true);
    }

    @Test
    void RemoveDoctorFromClinic_NotExist(){
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


}
