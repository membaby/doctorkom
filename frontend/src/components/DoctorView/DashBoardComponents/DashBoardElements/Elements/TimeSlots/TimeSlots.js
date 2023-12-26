import React from "react";
import DashElement from "../DashBoardElement/DashElement.js";
import TimeSlotsList from "./TimeSlotsList.js";

const timeSlots = {
    name: "Working Schedule",
    description: "check your time slots available for booking",
    div : <TimeSlotsList />
}
//return a DashElement component with props
export default function TimeSlots() {
    return (
        <DashElement {...timeSlots}/>
    );
}
