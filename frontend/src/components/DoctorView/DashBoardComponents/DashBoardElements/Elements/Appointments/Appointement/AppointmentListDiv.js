import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function AppointmentListDiv({ appointment }) {
    const { timeSlot, patient } = appointment;

    const { clinic, date, startTime, endTime } = timeSlot;
    const { firstName, lastName } = patient.systemUser;

    const [isFormVisible, setFormVisibility] = useState(false);

    // Calculate day and duration
    const day = new Intl.DateTimeFormat('en-US', { weekday: 'long' }).format(new Date(date));
    const startDateTime = new Date(`${date}T${startTime}`);
    const endDateTime = new Date(`${date}T${endTime}`);
    const durationInMinutes = Math.round((endDateTime - startDateTime) / (1000 * 60));

    const toggleFormVisibility = () => {
        setFormVisibility((prevVisibility) => !prevVisibility);
    };

    return (
        <div
            className="list-group-item list-group-item-action d-flex gap-3 py-3"
            style={{
                border: '1px solid rgb(36, 44, 60)',
                borderRadius: '0.25rem',
                backgroundColor: 'rgb(175, 238, 238)',
                marginBottom: '5px',
                marginTop: '5px'
            }}
        >
            <div className="w-100">
                <div className="d-flex justify-content-between">
                    <h6 className="mb-0">{clinic.name}</h6>
                    <p className="mb-0">Patient: {firstName} {lastName}</p>
                    <div className="mb-0">{day}, {date}</div>
                </div>
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
                <button
                type="button"
                className="btn btn-primary myButton"
                onClick={toggleFormVisibility}
                >
                {isFormVisible ? 'Hide Form' : 'Show Form'}
                </button>
                {isFormVisible && (
                     <form>
                        <div class="mb-3">
                            <label for="diagnosis" class="form-label">diagnosis</label>
                            <input  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
                        </div>
                        <div class="mb-3">
                            <label for="prescription" class="form-label">prescription</label>
                            <input  type="text" class="form-control" id="exampleInputPassword1"/>
                        </div>
                        <div class="mb-3">
                            <label for="investigations" class="form-label">investigations</label>
                            <input type="text" class="form-control" id="exampleInputPassword1"/>
                        </div>
                        
                        <button type="submit" class="btn btn-primary myButton">Submit</button>
                    </form>
                )}
                
            </div>
            
        </div>
    );
}