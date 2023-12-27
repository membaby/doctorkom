import MedicalNote from './MedicalNoteClass';

export default function GetMedicalNotes() {
  const patient1 = {
    id: 1,
    occupation: "Engineer",
    maritalStatus: "Single",
    insurance: "Health Insurance",
    systemUser: {
      id: 101,
      firstName: "John",
      lastName: "Doe",
      birthdate: "1990-01-01",
      gender: "Male",
      address: "123 Main St",
      mobilePhone: "123-456-7890",
      landlinePhone: "987-654-3210",
      account: {
        id: 1001,
        email: "john.doe@example.com",
        username: "johndoe",
        password: "password",
        role: "patient",
      },
    },
  };

  const doctor1 = {
    id: 1,
    title: "Dr.",
    specialty: "General Medicine",
    systemUser: {
      id: 201,
      firstName: "Jane",
      lastName: "Smith",
      birthdate: "1985-05-15",
      gender: "Female",
      address: "456 Oak St",
      mobilePhone: "111-222-3333",
      landlinePhone: "444-555-6666",
      account: {
        id: 2001,
        email: "drjane@example.com",
        username: "drjane",
        password: "doctor123",
        role: "doctor",
      },
    },
  };

  const medicalNote1 = new MedicalNote(
    "2023-01-01",
    "Headache",
    "MRI",
    "Painkillers",
    patient1,
    doctor1
  );
  const medicalNote2 = new MedicalNote(
    "2023-01-09",
    "Amnesia",
    "MRI",
    "Painkillers",
    patient1,
    doctor1
  );

  // Create more medical notes as needed
  const medicalNotes = [medicalNote1, medicalNote1, medicalNote1, medicalNote1, medicalNote1, medicalNote1
    , medicalNote2, medicalNote2, medicalNote2, medicalNote2, medicalNote2, medicalNote2];

  return medicalNotes;
}
