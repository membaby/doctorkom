import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetAppointments from './Appointement/GetAppointments.js';

export default function AppointmentsList(props) {
  const appointmentsList = GetAppointments({});

  return (
    <div className="list-group" style={{ maxHeight: "400px", overflowY: "scroll", border: '1px solid rgb(36, 44, 60)', borderRadius: '0.25rem' }}>
      {appointmentsList}
    </div>
  );
}
