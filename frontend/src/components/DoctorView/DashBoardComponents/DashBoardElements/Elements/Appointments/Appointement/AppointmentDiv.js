import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function AppointmentDiv(appointment) {
    const { timeSlot, patient } = appointment;

    const { clinic, date, startTime, endTime } = timeSlot;
    const { firstName, lastName } = patient.systemUser;

    // Calculate day and duration
    const day = new Intl.DateTimeFormat('en-US', { weekday: 'long' }).format(new Date(date));
    const startDateTime = new Date(`${date}T${startTime}`);
    const endDateTime = new Date(`${date}T${endTime}`);
    const durationInMinutes = Math.round((endDateTime - startDateTime) / (1000 * 60));

    return (
        <a
            className="list-group-item list-group-item-action d-flex gap-3 py-3"
            aria-current="true"
            style={{
                border: '1px solid rgb(36, 44, 60)',
                borderRadius: '0.25rem', // Optional: Adjust the border radius as needed
            }}
        >
            <div className="d-flex gap-2 w-100 justify-content-between">
                <div>
                    <h6 className="mb-0">{clinic.name}</h6>
                    <p className="mb-0 opacity-75">{day}, {date}</p>
                    <p className="mb-0 opacity-75">Start Time: {startTime}</p>
                    <p className="mb-0 opacity-75">End Time: {endTime}</p>
                    <p className="mb-0 opacity-75">Duration: {durationInMinutes} minutes</p>
                    <p className="mb-0 opacity-75">Patient: {firstName} {lastName}</p>
                </div>
            </div>
        </a>
    );
}
