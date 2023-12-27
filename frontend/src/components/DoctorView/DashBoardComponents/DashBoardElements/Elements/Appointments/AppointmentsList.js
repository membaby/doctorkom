import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetAppointments from './/Appointement/GetAppointments.js';
import AppointmentListDiv from './Appointement/AppointmentListDiv.js';
import AppointmentsTable from './AppointmentsTable.js';
import './AppointmentsList.css';

export default function AppointmentsList() {
  const appointmentsListObjects = GetAppointments();
  const appointmentsList = appointmentsListObjects.map((appointment) => (
    <AppointmentListDiv appointment={appointment} />
  ));

  const itemsPerPage = 5;
  const [currentPage, setCurrentPage] = useState(1);
  const [isTableView, setIsTableView] = useState(false);

  const totalPageCount = Math.ceil(appointmentsList.length / itemsPerPage);

  const handleNext = () => {
    setCurrentPage((prevPage) => (prevPage < totalPageCount ? prevPage + 1 : prevPage));
  };

  const handlePrev = () => {
    setCurrentPage((prevPage) => (prevPage > 1 ? prevPage - 1 : prevPage));
  };

  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  const visibleAppointments = appointmentsList.slice(startIndex, endIndex);

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
        <AppointmentsTable appointmentsListObjects={appointmentsListObjects} /> 
      ) : (
        <div className="list-group myContainer">
          {visibleAppointments}
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
