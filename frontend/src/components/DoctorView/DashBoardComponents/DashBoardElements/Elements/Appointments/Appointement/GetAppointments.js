import 'bootstrap/dist/css/bootstrap.min.css';
import Appointment from "./AppointmentClass";
import secureLocalStorage from "react-secure-storage";
import getDoctorAppointments from '../../../../../../../functions/getDoctorAppointments';

export default async function GetAppointments() {

  const doctorId = secureLocalStorage.getItem('id');

  try {
    const data = await getDoctorAppointments(doctorId);

    let appointments = [];

    for (let i = 0; i < data.length; i++) {
      let appointment = new Appointment(
        data[i].timeSlot,
        data[i].patient
      );
      appointments.push(appointment);
    }

    return appointments;
  } catch (error) {
    console.error('Error fetching doctor time slots:', error);
    return [];
  }

}
