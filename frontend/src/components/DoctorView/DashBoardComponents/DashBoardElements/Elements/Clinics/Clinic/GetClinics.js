import Clinic from './ClinicClass.js'
import secureLocalStorage from "react-secure-storage";
import getDoctorClinics from '../../../../../../../functions/getDoctorClinics';

export default async function GetClinics() {

    const doctorId = secureLocalStorage.getItem('id');    
    let clinics = []

    try {
      const data = await getDoctorClinics(doctorId);
      for (let i = 0; i < data.length; i++) {
        let clinic = new Clinic(
          data[i].id,
          data[i].name,
          data[i].address,
          data[i].email,
          data[i].mobilePhone,
          data[i].landlinePhone,
          data[i].admin
        );
        clinics.push(clinic);
      }
      return data;
    } catch (error) {
      console.error('Error fetching doctor time slots:', error);
      return [];
    }
}