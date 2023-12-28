import React,{ useState, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetClinics from './Clinic/GetClinics.js';
import ClinicListDiv from './Clinic/ClinicListDiv.js';
import './ClinicsList.css';

export default function ClinicsList() {

  const [clinicsListObjects, setClinicsListObjects] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPageCount, setTotalPageCount] = useState(0);
  const itemsPerPage = 5;

  useEffect(() => {
    const fetchData = async () => {
      try {
        const clinicsList = await GetClinics();
        setClinicsListObjects(clinicsList);
        setTotalPageCount(Math.ceil(clinicsList.length / itemsPerPage));
      } catch (error) {
        console.error('Error fetching time slots:', error);
        // Handle the error as needed
      }
    };

    fetchData();
  }, []);

  const handleNext = () => {
    setCurrentPage(prevPage => prevPage < totalPageCount ? prevPage + 1 : prevPage);
  };

  const handlePrev = () => {
    setCurrentPage(prevPage => prevPage > 1 ? prevPage - 1 : prevPage);
  };

  return (
    <div>
      <div className="list-group myContainer">
        {
          clinicsListObjects.slice((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage).map((clinic) => (
            <ClinicListDiv clinic={clinic} />
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
    </div>
  );
}