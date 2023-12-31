import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';


export default function TimeSlotTableDiv({timeSlot}) {
    const { clinic, date, startTime, endTime } = timeSlot;

    // Calculate day and duration
    const startDateTime = new Date(`${date}T${startTime}`);
    const endDateTime = new Date(`${date}T${endTime}`);
    const durationInMinutes = Math.round((endDateTime - startDateTime) / (1000 * 60));

    return (
        <a 
            className="list-group-item list-group-item-action d-flex gap-3 py-3 "
            aria-current="true"
            style={{
                border: '1px solid rgb(36, 44, 60)',
                borderRadius: '0.25rem', // Optional: Adjust the border radius as needed
                backgroundColor: 'rgb(175,238,238)',
                marginBottom: '5px',
                marginTop: '5px',
                textAlign: 'center',
            }}
        >
            <div className="d-flex gap-2 w-100 justify-content-between" >
                <div >
                    <h6 className="mb-0">{clinic.name}</h6>
                    <p className="mb-0">From: {startTime}</p>
                    <p className="mb-0">To: {endTime}</p>
                    <p className="mb-0">{durationInMinutes} minutes</p>
                </div>
            </div>
        </a>
    );
}