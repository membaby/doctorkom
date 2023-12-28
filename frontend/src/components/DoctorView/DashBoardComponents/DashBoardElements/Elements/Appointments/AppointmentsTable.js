// AppointmentsTable.js
import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './AppointmentsTable.css';
import AppointmentTableDiv from "./Appointement/AppointmrentTableDiv.js";

export default function AppointmentsTable({ appointmentsListObjects }) {
  const groupedAppointments = groupAppointmentsByDay(appointmentsListObjects);

  const daysOfWeek = ["Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];

  return (
    <div className="container myContainer" style={{ overflowY: "scroll", maxHeight: "400px" }}>
      <div className="row">
        {daysOfWeek.map((day, index) => (
          <div key={index} className="col myCol">
            <div className="biggerThickerTextt">{day}</div>
            {groupedAppointments[day]?.map((appointment) => (
              <AppointmentTableDiv appointment={appointment} />
            ))}
          </div>
        ))}
      </div>
    </div>
  );
}

function groupAppointmentsByDay(appointmentsListObjects) {
  return appointmentsListObjects.reduce((grouped, appointment) => {
    const day = new Intl.DateTimeFormat('en-US', { weekday: 'long' }).format(new Date(appointment.timeSlot.date));
    grouped[day] = grouped[day] || [];
    grouped[day].push(appointment);
    return grouped;
  }, {});
}
