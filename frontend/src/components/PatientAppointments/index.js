import React from "react";
import { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';


export default function PatientAppointments() {
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        setAppointments([
            {'date': '2021-01-01', 'time': '12:00', 'doctor': 'Dr. John Doe', 'clinic': 'Clinic 1', 'status': 'Scheduled'},
            {'date': '2021-01-02', 'time': '13:00', 'doctor': 'Dr. John Doe', 'clinic': 'Clinic 1', 'status': 'Scheduled'},
            {'date': '2021-01-03', 'time': '14:00', 'doctor': 'Dr. John Doe', 'clinic': 'Clinic 1', 'status': 'Scheduled'},
            {'date': '2021-01-04', 'time': '15:00', 'doctor': 'Dr. John Doe', 'clinic': 'Clinic 1', 'status': 'Scheduled'},
            {'date': '2021-01-05', 'time': '16:00', 'doctor': 'Dr. John Doe', 'clinic': 'Clinic 1', 'status': 'Scheduled'},
        ])
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
                                <td>{appointment.date} {appointment.time}</td>
                                <td>{appointment.doctor}</td>
                                <td>{appointment.clinic}</td>
                                <td>{appointment.status}</td>
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