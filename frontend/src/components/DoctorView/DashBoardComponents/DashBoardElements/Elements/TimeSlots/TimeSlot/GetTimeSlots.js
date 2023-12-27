import 'bootstrap/dist/css/bootstrap.min.css';
import TimeSlot from "./TimeSlotClass";


export default function GetTimeSlots(props) {
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

  const timeSlot1 = new TimeSlot(clinic1, doctor1, "2023-05-01", "09:00", "10:00", false);

  const clinic2 = {
    id: 2,
    name: "Clinic B",
    address: "456 Oak St",
    email: "clinicB@example.com",
    mobilePhone: "111-222-3333",
    landlinePhone: "444-555-6666",
    admin: {
      id: 102,
      account: {
        id: 202,
        email: "adminB@example.com",
        username: "adminB",
        password: "adminB123",
        role: "CLINIC_ADMIN",
      },
    },
  };

  const doctor2 = {
    id: 2,
    title: "Dr.",
    specialty: "Dermatology",
    systemUser: {
      id: 302,
      firstName: "Jane",
      lastName: "Smith",
      birthdate: "1985-05-15",
      gender: "FEMALE",
      address: "789 Pine St",
      mobilePhone: "777-888-9999",
      landlinePhone: "000-111-2222",
      account: {
        id: 402,
        email: "drjane@example.com",
        username: "drjane",
        password: "doctor456",
        role: "DOCTOR",
      },
    },
  };

  const timeSlot2 = new TimeSlot(clinic2, doctor2, "2023-05-02", "11:00", "12:30", true);

  const clinic3 = {
    id: 3,
    name: "Clinic C",
    address: "789 Pine St",
    email: "clinicC@example.com",
    mobilePhone: "777-888-9999",
    landlinePhone: "000-111-2222",
    admin: {
      id: 103,
      account: {
        id: 203,
        email: "adminC@example.com",
        username: "adminC",
        password: "adminC123",
        role: "CLINIC_ADMIN",
      },
    },
  };

  const doctor3 = {
    id: 3,
    title: "Dr.",
    specialty: "Pediatrics",
    systemUser: {
      id: 303,
      firstName: "Chris",
      lastName: "Johnson",
      birthdate: "1978-08-20",
      gender: "MALE",
      address: "101 Maple Ave",
      mobilePhone: "999-888-7777",
      landlinePhone: "555-444-3333",
      account: {
        id: 403,
        email: "drchris@example.com",
        username: "drchris",
        password: "doctor789",
        role: "DOCTOR",
      },
    },
  };

  const timeSlot3 = new TimeSlot(clinic3, doctor3, "2023-05-03", "14:00", "15:30", false);

  const timeSlots  = [timeSlot1,timeSlot2,timeSlot3,timeSlot1,timeSlot2];
  return timeSlots;
}
