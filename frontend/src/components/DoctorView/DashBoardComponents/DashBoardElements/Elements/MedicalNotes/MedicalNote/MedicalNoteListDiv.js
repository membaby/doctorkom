import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function MedicalNoteListDiv({ medicalNote }) {
    const { date, patient, prescription, diagnosis, investigations } = medicalNote;
    const id = "medicalNotes";
    //get the element with id = id

    const [isContentVisible, setContentVisibility] = useState(false);

    const toggleContentVisibility = () => {
        setContentVisibility((prevVisibility) => !prevVisibility);
    };

    return (
        <a
        className="list-group-item list-group-item-action d-flex gap-3 py-3"
        aria-current="true"
        style={{
            border: '1px solid rgb(36, 44, 60)',
            borderRadius: '0.25rem',
            backgroundColor: 'rgb(175, 238, 238)',
            marginBottom: '5px',
            marginTop: '5px'
        }}
        onClick={() => {
                toggleContentVisibility();
        }}
        onMouseEnter={() => {
                // change mouse cursor to pointer
                document.body.style.cursor = "pointer";
        }}
        onMouseLeave={() => {
                // change mouse cursor to pointer
                document.body.style.cursor = "default";
        }}
        >
        <div className="w-100">
            <div className="d-flex justify-content-between">
            <h6 className="mb-0">Patient: {patient.systemUser.lastName}, {patient.systemUser.firstName}</h6>
            <div className="mb-0">{date}</div>
            </div>
            <div>
            {isContentVisible && (
                <div>
                <p>Prescription: {prescription}</p>
                <p>Diagnosis: {diagnosis}</p>
                <p>Investigations: {investigations}</p>
                </div>
            )}
            </div>
        </div>
        </a>
    );
}
