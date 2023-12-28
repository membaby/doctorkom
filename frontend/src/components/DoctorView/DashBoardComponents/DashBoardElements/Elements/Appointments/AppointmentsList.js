import React, { useState, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetAppointments from './/Appointement/GetAppointments.js';
import AppointmentListDiv from './Appointement/AppointmentListDiv.js';
import AppointmentsTable from './AppointmentsTable.js';
import './AppointmentsList.css';

export default function AppointmentsList() {

  const [appointmentListObjects, setAppointmentListObjects] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [isTableView, setIsTableView] = useState(false);
  const [totalPageCount, setTotalPageCount] = useState(0);

  const itemsPerPage = 5;

  useEffect(() => {
    const fetchData = async () => {
      try {
        const appointments = await GetAppointments();
        setAppointmentListObjects(appointments);
        setTotalPageCount(Math.ceil(appointments.length / itemsPerPage));
      } catch (error) {
        console.error('Error fetching time slots:', error);
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
        <AppointmentsTable appointmentsListObjects={appointmentListObjects} /> 
      ) : (
        <div className="list-group myContainer">
          {
            appointmentListObjects.slice((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage).map((appointment) => (
              <AppointmentListDiv appointment={appointment} />
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
