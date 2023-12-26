import 'bootstrap/dist/css/bootstrap.min.css';
import Appointment from "./AppointmentClass";
import TimeSlot from "../../TimeSlots/TimeSlot/TimeSlotClass.js";

export default function GetAppointments(props) {
    const clinic1 = {
        id: 1,
        name: "Clinic A",
        address: "123 Main St",
        email: "clinicA@example.com",
        mobilePhone: "123-456-7890",
        landlinePhone: "987-654-3210",
        admin: {
          id: 101,
          account: {
            id: 201,
            email: "adminA@example.com",
            username: "adminA",
            password: "adminA123",
            role: "CLINIC_ADMIN",
          },
        },
      };
      
      const doctor1 = {
        id: 1,
        title: "Dr.",
        specialty: "General Medicine",
        systemUser: {
          id: 301,
          firstName: "John",
          lastName: "Doe",
          birthdate: "1990-01-01",
          gender: "MALE",
          address: "456 Oak St",
          mobilePhone: "111-222-3333",
          landlinePhone: "444-555-6666",
          account: {
            id: 401,
            email: "drjohn@example.com",
            username: "drjohn",
            password: "doctor123",
            role: "DOCTOR",
          },
        },
      };
      
      const patient1 = {
        id: 1,
        occupation: "Software Engineer",
        maritalStatus: "Single",
        insurance: "XYZ Insurance",
        systemUser: {
          id: 501,
          firstName: "Alice",
          lastName: "Johnson",
          birthdate: "1988-05-10",
          gender: "FEMALE",
          address: "789 Maple St",
          mobilePhone: "555-666-7777",
          landlinePhone: "888-999-0000",
          account: {
            id: 601,
            email: "alice@example.com",
            username: "alice",
            password: "alice123",
            role: "PATIENT",
          },
        },
      };
      
    const timeSlot1 = new TimeSlot(clinic1, doctor1, "2023-05-01", "09:00", "10:00", false);
      
  const appointment1 = new Appointment(timeSlot1, patient1);
  const appointment2 = new Appointment(timeSlot1, patient1);
  const appointment3 = new Appointment(timeSlot1, patient1);

  const appointments = [appointment1, appointment2, appointment3];

  return appointments;  
}
