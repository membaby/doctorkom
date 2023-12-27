import React,{ useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetClinics from './Clinic/GetClinics.js';
import ClinicListDiv from './Clinic/ClinicListDiv.js';
import './ClinicsList.css';

export default function ClinicsList() {
  const clinicsListObjects = GetClinics();
  const clinicsList = clinicsListObjects.map((clinic) => <ClinicListDiv clinic={clinic} />);
  const itemsPerPage = 5;
  const [currentPage, setCurrentPage] = React.useState(1);
  const totalPageCount = Math.ceil(clinicsList.length / itemsPerPage);

  const handleNext = () => {
    setCurrentPage(prevPage => prevPage < totalPageCount ? prevPage + 1 : prevPage);
  };

  const handlePrev = () => {
    setCurrentPage(prevPage => prevPage > 1 ? prevPage - 1 : prevPage);
  };

  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  const visibleClinics = clinicsList.slice(startIndex, endIndex);
  return (
    <div>
      <div className="list-group myContainer">
        {visibleClinics}
        <div className="d-flex justify-content-between mt-3">
          <button className="btn buttonColored" onClick={handlePrev} disabled={currentPage === 1}>
            Previous
          </button>
          <button className="btn buttonColored" onClick={handleNext} disabled={currentPage === totalPageCount}>
            Next
          </button>
        </div>
      </div>
    </div>
  );
}