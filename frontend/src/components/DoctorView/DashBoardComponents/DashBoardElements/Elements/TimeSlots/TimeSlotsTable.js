// TimeSlotsTable.js
// TimeSlotsTable.js
import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './TimeSlotsTable.css';
import TimeSlotTableDiv from "./TimeSlot/TimeSlotTableDiv";

export default function TimeSlotsTable({ timeSlotsListObjects }) {
  // Group the time slots by day of the week
  const groupedTimeSlots = groupTimeSlotsByDay(timeSlotsListObjects);

  const daysOfWeek = ["Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];

  return (
    <div className="container myContainer" style={{ overflowY: "scroll", maxHeight: "400px" }}>
      <div className="row ">
        {daysOfWeek.map((day, index) => (
          <div key={index} className="col myCol">
            <div className="biggerThickerTextt">{day}</div>
            {groupedTimeSlots[day]?.map((timeSlot) => (
                <TimeSlotTableDiv timeSlot={timeSlot} />
            ))}
          </div>
        ))}
      </div>
    </div>
  );
}

function groupTimeSlotsByDay(timeSlotsListObjects) {
  return timeSlotsListObjects.reduce((grouped, timeSlot) => {
    const day = new Intl.DateTimeFormat('en-US', { weekday: 'long' }).format(new Date(timeSlot.date));
    grouped[day] = grouped[day] || [];
    grouped[day].push(timeSlot);
    return grouped;
  }, {});
}
