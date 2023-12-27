import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css'; // import the styles
import MedicalNote from './../../MedicalNotes/MedicalNote/MedicalNoteClass.js'
import PostMedicalNote from './PostMedicalNote.js'
import RemoveAppointment from './RemoveAppointment.js'

export default function AppointmentListDiv({ appointment }) {
    const { timeSlot, patient } = appointment;

    const { clinic, date, startTime, endTime } = timeSlot;
    const { firstName, lastName } = patient.systemUser;

    const id = patient.id+date+startTime;

    const [isFormVisible, setFormVisibility] = useState(false);
    const [diagnosis, setDiagnosis] = useState('');
    const [prescription, setPrescription] = useState('');
    const [investigations, setInvestigations] = useState('');

    // Calculate day and duration
    const day = new Intl.DateTimeFormat('en-US', { weekday: 'long' }).format(new Date(date));
    const startDateTime = new Date(`${date}T${startTime}`);
    const endDateTime = new Date(`${date}T${endTime}`);
    const durationInMinutes = Math.round((endDateTime - startDateTime) / (1000 * 60));

    const toggleFormVisibility = () => {
        setFormVisibility((prevVisibility) => !prevVisibility);
    };

    const handleFormSubmit = (e) => {
        e.preventDefault();
        let newinvestigations = `${investigations}`;
        let newprescription = `${prescription}`;
        let newdiagnosis = `${diagnosis}`;
        const medicalNote = new MedicalNote(date, newdiagnosis, newinvestigations, newprescription, patient, timeSlot.doctor);
        if (newinvestigations !== '' || newprescription !== '' || newdiagnosis !== '') {
            PostMedicalNote(medicalNote);
            console.log(medicalNote);
        }
        RemoveAppointment(appointment);
        console.log(appointment);
        //delete the current appointment div with id = id
        const appointmentDiv = document.getElementById(id);
        if (appointmentDiv) {
            appointmentDiv.remove();
        }


    };

    return (
        <div id = {id}
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
                     <form onSubmit={handleFormSubmit}>
                        <div className="mb-3">
                            <label htmlFor="diagnosis" className="form-label"><h5>Diagnosis</h5></label>
                            <ReactQuill value={diagnosis} onChange={(value) => setDiagnosis(value)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="prescription" className="form-label"><h5>Prescription</h5></label>
                            <ReactQuill value={prescription} onChange={(value) => setPrescription(value)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="investigations" className="form-label"><h5>Investigations</h5></label>
                            <ReactQuill value={investigations} onChange={(value) => setInvestigations(value)} />
                        </div>
                        
                        <button type="submit" className="btn btn-primary myButton">Submit</button>
                    </form>
                )}
            </div>
            
        </div>
    );
}
