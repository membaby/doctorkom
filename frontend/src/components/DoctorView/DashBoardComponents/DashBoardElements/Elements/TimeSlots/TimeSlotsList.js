// TimeSlotsList.js
import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetTimeSlots from './TimeSlot/GetTimeSlots.js';
import TimeSlotListDiv from "./TimeSlot/TimeSlotListDiv.js";
import TimeSlotsTable from "./TimeSlotsTable.js";
import './TimeSlotsList.css';

export default function TimeSlotsList() {
  const timeSlotsListObjects = GetTimeSlots();
  const timeSlotsList = timeSlotsListObjects.map((timeSlot) => (
    <TimeSlotListDiv timeSlot={timeSlot} />
  ));

  const itemsPerPage = 3;
  const [currentPage, setCurrentPage] = useState(1);
  const [isTableView, setIsTableView] = useState(false);

  const totalPageCount = Math.ceil(timeSlotsList.length / itemsPerPage);

  const handleNext = () => {
    setCurrentPage((prevPage) => (prevPage < totalPageCount ? prevPage + 1 : prevPage));
  };

  const handlePrev = () => {
    setCurrentPage((prevPage) => (prevPage > 1 ? prevPage - 1 : prevPage));
  };

  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  const visibleTimeSlots = timeSlotsList.slice(startIndex, endIndex);

  const toggleView = () => {
    setIsTableView((prevValue) => !prevValue);
  };

  return (
    <div>
      <div className="d-flex justify-content-end mb-3">
        <button className="btn btn-secondary" onClick={toggleView}>
          {isTableView ? 'List View' : 'Table View'}
        </button>
      </div>
      {isTableView ? (
        <TimeSlotsTable timeSlotsListObjects={timeSlotsListObjects} />
      ) : (
        <div className="list-group myContainer">
          {visibleTimeSlots}
          <div className="d-flex justify-content-between mt-3">
            <button className="btn buttonColored" onClick={handlePrev} disabled={currentPage === 1}>
              Previous
            </button>
            <button className="btn buttonColored" onClick={handleNext} disabled={currentPage === totalPageCount}>
              Next
            </button>
          </div>
        </div>
      )}
    </div>
  );
}
