import MedicalNote from './MedicalNoteClass';
import getDoctorMedicalNotes from '../../../../../../../functions/getDoctorMedicalNotes';
import secureLocalStorage from "react-secure-storage";

export default async function GetMedicalNotes() {

  const doctorId = secureLocalStorage.getItem('id');

  try {
    const data = await getDoctorMedicalNotes(doctorId);

    let medicalNotes = [];

    for (let i = 0; i < data.length; i++) {
      let medicalNote = new MedicalNote(
        data[i].date,
        data[i].diagnosis,
        data[i].investigations,
        data[i].prescription,
        data[i].patient,
        data[i].doctor
      )
      medicalNotes.push(medicalNote);
    }

    return medicalNotes;
  } catch (error) {
    console.error('Error fetching doctor time slots:', error);
    return [];
  }

}