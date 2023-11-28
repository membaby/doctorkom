package com.example.doctorkom.Controllers;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Repositories.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private ClinicRepository clinicRepository; //  ClinicRepository that interacts with database

    @PostMapping
    public ResponseEntity<String> createClinic(@RequestBody Clinic clinicData) {
        // Validate clinic data
        if (!isValidClinic(clinicData)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid clinic data");
        }
        try {
            // Save the clinic data
            clinicRepository.save(clinicData);
            return ResponseEntity.status(HttpStatus.CREATED).body("Clinic created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating clinic");
        }
    }


    public static boolean isValidClinic(Clinic clinic) {
        return isNameValid(clinic.getName())
                && isEmailValid(clinic.getEmail())
                && isAddressValid(clinic.getAddress())
                && isPhoneValid(clinic.getPhone())
                && isLandlineValid(clinic.getLandline());
    }

    private static boolean isNameValid(String name) {
        return name != null && !name.isEmpty();
    }

    private static boolean isEmailValid(String email) {
        // Simple email validation using regex
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    private static boolean isAddressValid(String address) {
        return address != null && !address.isEmpty();
    }

    private static boolean isPhoneValid(String phone) {
        // Simple phone number validation using regex
        String phoneRegex = "^[0-9]+$";
        return phone != null && phone.matches(phoneRegex);
    }

    private static boolean isLandlineValid(String landline) {
        // Simple landline number validation using regex
        String landlineRegex = "^[0-9]+$";
        return landline != null && landline.matches(landlineRegex);
    }
}
