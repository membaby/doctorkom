import React from "react";
import DashElement from "../DashBoardElement/DashElement";
import ClinicsList from "./ClinicsList.js";
const clinics = {
    name: "Clinics",
    description: "check clinicks you are working in",
    div : ClinicsList({}) 
}
//return a DashElement component with props
export default function Clinics() {
    return (
        <DashElement {...clinics}/>
    );
}