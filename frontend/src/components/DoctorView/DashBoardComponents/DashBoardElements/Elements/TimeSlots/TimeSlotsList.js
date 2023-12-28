// TimeSlotsList.js
import React, { useState, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetTimeSlots from './TimeSlot/GetTimeSlots.js';
import TimeSlotListDiv from "./TimeSlot/TimeSlotListDiv.js";
import TimeSlotsTable from "./TimeSlotsTable.js";
import './TimeSlotsList.css';

export default function TimeSlotsList() {

  const [timeSlotsListObjects, setTimeSlotsListObjects] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [isTableView, setIsTableView] = useState(false);
  const [totalPageCount, setTotalPageCount] = useState(0);

  const itemsPerPage = 5;

  useEffect(() => {
    const fetchData = async () => {
      try {
        const timeSlotsList = await GetTimeSlots();
        setTimeSlotsListObjects(timeSlotsList);
        setTotalPageCount(Math.ceil(timeSlotsList.length / itemsPerPage));
      } catch (error) {
        console.error('Error fetching time slots:', error);
        // Handle the error as needed
      }
    };

    fetchData();
  }, []);


  const handleNext = () => {
    setCurrentPage((prevPage) => (prevPage < totalPageCount ? prevPage + 1 : prevPage));
  };

  const handlePrev = () => {
    setCurrentPage((prevPage) => (prevPage > 1 ? prevPage - 1 : prevPage));
  };

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
          {
            timeSlotsListObjects.slice((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage).map((timeSlot) => (
              <TimeSlotListDiv timeSlot={timeSlot} />
            ))
          }
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
