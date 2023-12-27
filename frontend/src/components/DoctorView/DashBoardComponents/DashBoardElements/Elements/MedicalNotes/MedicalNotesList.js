import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import GetMedicalNotes from './MedicalNote/GetMedicalNotes.js';
import MedicalNoteListDiv from './MedicalNote/MedicalNoteListDiv.js';
import './MedicalNotesList.css'; 

export default function MedicalNotesList() {
  const medicalNotesListObjects = GetMedicalNotes();
  const medicalNotesList = medicalNotesListObjects.map((medicalNote) => (
    <MedicalNoteListDiv medicalNote={medicalNote} />
  ));

  const itemsPerPage = 5;
  const [currentPage, setCurrentPage] = useState(1);

  const totalPageCount = Math.ceil(medicalNotesList.length / itemsPerPage);

  const handleNext = () => {
    setCurrentPage((prevPage) => (prevPage < totalPageCount ? prevPage + 1 : prevPage));
  };

  const handlePrev = () => {
    setCurrentPage((prevPage) => (prevPage > 1 ? prevPage - 1 : prevPage));
  };

  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  const visibleMedicalNotes = medicalNotesList.slice(startIndex, endIndex);

  return (
      <div className="list-group myContainer container" >
        {visibleMedicalNotes}
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
