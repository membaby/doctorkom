import React from "react";
import DashElement from "../DashBoardElement/DashElement";
import MedicalNotesList from "./MedicalNotesList.js";

const medicalNotes = {
    name: "Medical Notes",
    description: "check medical notes of your patients",
    div : <MedicalNotesList/>
}
//return a DashElement component with props
export default function MedicalNotes() {
    return (
        <DashElement {...medicalNotes}/>
    );
}