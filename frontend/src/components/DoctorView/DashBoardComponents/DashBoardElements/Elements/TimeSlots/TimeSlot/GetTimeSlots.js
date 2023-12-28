import 'bootstrap/dist/css/bootstrap.min.css';
import TimeSlot from "./TimeSlotClass";
import getDoctorTimeslots from '../../../../../../../functions/getDoctorTimeslots';
import secureLocalStorage from "react-secure-storage";

export default async function GetTimeSlots(props) {

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


  const doctorId = secureLocalStorage.getItem('id');

  try {
    const data = await getDoctorTimeslots(doctorId);

    let timeSlots = [];

    for (let i = 0; i < data.length; i++) {
      for (let j = 0; j < data[i].timeSlots.length; j++) {
        let timeSlot = new TimeSlot(
          data[i].clinic,
          doctor1,
          data[i].timeSlots[j].date,
          data[i].timeSlots[j].startTime,
          data[i].timeSlots[j].endTime,
          data[i].timeSlots[j].reserved
        );
        timeSlots.push(timeSlot);
      }
    }

    return timeSlots;
  } catch (error) {
    console.error('Error fetching doctor time slots:', error);
    return [];
  }

}
