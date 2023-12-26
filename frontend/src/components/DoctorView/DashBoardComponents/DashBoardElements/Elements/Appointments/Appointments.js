import React from "react";
import DashElement from "../DashBoardElement/DashElement";
import AppointmentsList from "./AppointmentsList.js";

const appointments = {
    name: "Appointments",
    description: "check your pending appointments",
    div : <AppointmentsList />
}
//return a DashElement component with props
export default function Appointments() {
    return (
        <DashElement {...appointments}/>
    );
}