import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function AppointmentListDiv({appointment}) {
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
                backgroundColor: 'rgb(175, 238, 238)',
                marginBottom: '5px',
                marginTop: '5px'
            }}
        >
            <div className="w-100">
                <h6 className="mb-0">{clinic.name}</h6>
                <div className="mb-0">{day}, {date}</div>
                <p className="mb-0 opacity-75">Patient: {firstName} {lastName}</p>
                <div className="d-flex justify-content-between">
                    <div>
                        <p className="mb-0">Start Time: {startTime}</p>
                    </div>
                    <div>
                        <p className="mb-0">End Time: {endTime}</p>
                    </div>
                    <div>
                        <p className="mb-0">Duration: {durationInMinutes} minutes</p>
                    </div>
                </div>
            </div>
        </a>
    );
}

