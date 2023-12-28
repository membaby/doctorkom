import React, { useState, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetMedicalNotes from './MedicalNote/GetMedicalNotes.js';
import MedicalNoteListDiv from './MedicalNote/MedicalNoteListDiv.js';
import './MedicalNotesList.css'; 

export default function MedicalNotesList() {

  const [medicalNotesListObjects, setMedicalNotesListObjects] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPageCount, setTotalPageCount] = useState(0);
  
  const itemsPerPage = 5;

  useEffect(() => {
    const fetchData = async () => {
      try {
        const medicalNotesList = await GetMedicalNotes();
        setMedicalNotesListObjects(medicalNotesList);
        setTotalPageCount(Math.ceil(medicalNotesList.length / itemsPerPage));
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


  return (
      <div className="list-group myContainer container" >
        {
          medicalNotesListObjects.slice((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage).map((medicalNote) => (
            <MedicalNoteListDiv medicalNote={medicalNote} />
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
  );
}
