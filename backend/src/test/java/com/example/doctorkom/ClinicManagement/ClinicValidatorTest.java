package com.example.doctorkom.ClinicManagement;

import com.example.doctorkom.Controllers.ClinicController;
import com.example.doctorkom.Entities.Clinic;
import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClinicValidatorTest {

    // Test isValidClinic method with valid clinic data
    @Test
    public void testIsValidClinic_ValidData_ReturnsTrue() {
        Clinic validClinic = new Clinic("valid@email.com", "Valid Clinic", "Valid Address", "123456789", "987654321");
        ClinicController clinicController=new ClinicController();
        assertTrue(clinicController.isValidClinic(validClinic));
    }

    // Test isValidClinic method with invalid name
    @Test
    public void testIsValidClinic_InvalidName_ReturnsFalse() {
        Clinic invalidNameClinic = new Clinic("valid@email.com", "", "Valid Address", "123456789", "987654321");
        ClinicController clinicController=new ClinicController();
        assertFalse(clinicController.isValidClinic(invalidNameClinic));
    }

    // Test isValidClinic method with invalid email
    @Test
    public void testIsValidClinic_InvalidEmail_ReturnsFalse() {
        Clinic invalidEmailClinic = new Clinic("invalidemail", "Valid Clinic", "Valid Address", "123456789", "987654321");
        ClinicController clinicController=new ClinicController();
        assertFalse(clinicController.isValidClinic(invalidEmailClinic));
    }

    // Test isValidClinic method with invalid address
    @Test
    public void testIsValidClinic_InvalidAddress_ReturnsFalse() {
        Clinic invalidAddressClinic = new Clinic("valid@email.com", "Valid Clinic", "", "123456789", "987654321");
        ClinicController clinicController=new ClinicController();
        assertFalse(clinicController.isValidClinic(invalidAddressClinic));
    }

    // Test isValidClinic method with invalid phone
    @Test
    public void testIsValidClinic_InvalidPhone_ReturnsFalse() {
        Clinic invalidPhoneClinic = new Clinic("valid@email.com", "Valid Clinic", "Valid Address", "invalidphone", "987654321");
        ClinicController clinicController=new ClinicController();
        assertFalse(clinicController.isValidClinic(invalidPhoneClinic));
    }

    // Test isValidClinic method with invalid landline
    @Test
    public void testIsValidClinic_InvalidLandline_ReturnsFalse() {
        Clinic invalidLandlineClinic = new Clinic("valid@email.com", "Valid Clinic", "Valid Address", "123456789", "invalidlandline");
        ClinicController clinicController=new ClinicController();
        assertFalse(clinicController.isValidClinic(invalidLandlineClinic));
    }
}
