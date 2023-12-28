import React from "react";
import { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import secureLocalStorage from 'react-secure-storage';


export default function PatientAppointments() {
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        const patient_id = secureLocalStorage.getItem('id');
        // fetch(`http://localhost:8080/appointments/${patient_id}/1`, {
        fetch(`http://localhost:8080/patient/appointments/1195/0`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        }).then((response) => response.json())
        .then((data) => {
            setAppointments(data.content);
        })
    }, []);

    return (
        <div>
            <div class="container py-4 py-xl-5">
                <h3>My Appointments</h3>
                <hr/>

                <table class="table table-striped table-hover">
                    <thead>
                        <th>Date/Time</th>
                        <th>Doctor Name</th>
                        <th>Clinic Name</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </thead>
                    <tbody>
                        {appointments.map((appointment) => (
                            <tr>
                                <td>{appointment.timeSlot.date} {appointment.timeSlot.startTime}</td>
                                <td>{appointment.timeSlot.doctor.systemUser.firstName} {appointment.timeSlot.doctor.systemUser.lastName}</td>
                                <td>{appointment.timeSlot.clinic.name}</td>
                                <td>Booked</td>
                                <td>
                                    <button class="btn btn-danger">Cancel</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>

            </div>
        </div>
    )
}