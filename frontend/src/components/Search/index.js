import React, { useState } from "react";
import Result from "./Result";
import getDoctorsList from "../../functions/getDoctorsList";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function Search() {

    const cities = ['Alexandria', 'Cairo', 'Giza', 'Ismailia', 'Luxor', 'Port Said', 'Suez', 'Aswan', 'Asyut', 'Beheira', 'Beni Suef', 'Dakahlia', 'Damietta', 'Faiyum', 'Gharbia', 'Kafr El Sheikh', 'Matruh', 'Minya', 'Monufia', 'New Valley', 'North Sinai', 'Qalyubia', 'Qena', 'Red Sea', 'Sharqia', 'Sohag', 'South Sinai', '6th of October'];
    const titles = ['PROFESSOR', 'LECTURER', 'CONSULTANT', 'SPECIALIST'];
    const specialties = ['GENERAL_PRACTITIONER', 'CARDIOLOGIST', 'DERMATOLOGIST', 'PEDIATRICIAN', 'ORTHOPEDIC_SURGEON', 'GYNECOLOGIST', 'OPHTHALMOLOGIST', 'NEUROLOGIST', 'UROLOGIST', 'ENT_SPECIALIST', 'PSYCHIATRIST', 'ONCOLOGIST', 'RADIOLOGIST', 'ANESTHESIOLOGIST', 'DENTAL_SURGEON'];

    const [showingResults, setShowingResults] = useState(false);
    const [results, setResults] = useState([]);
    const [totalResults, setTotalResults] = useState(0);
    const [currentPage, setCurrentPage] = useState(0);

    
    const search = (direction) => {
        const city = document.getElementById('city').value;
        const title = document.getElementById('title').value;
        const specialty = document.getElementById('specialty').value;
        const keyword = document.getElementById('keyword').value;

        let page = currentPage;
        if (direction === "next") {
            page += 1;
        } else if (direction === "prev") {
            page -= 1;
        }
        setCurrentPage(page);

        setMessage("Searching for doctors that match your criteria...");
        getDoctorsList(keyword, city, title, specialty, page)
        .then(data => {
            setResults(data.content);
            setTotalResults(data.totalElements);
            setShowingResults(true);
            setMessage("");
            window.scrollTo(0, 0);
        })
    }

    const setMessage = (message) => {
        document.getElementById('displayMessage').innerHTML = message;
    }

    const handleKeyPress = (event) => {
        if (event.key === 'Enter') {
            search();
        }
    };
    

    return (
        <div>
            <div class="container py-4 py-xl-5">
                <h3>Find Your Ideal Healthcare Provider</h3>
                <hr/>
                <div className="alert text-center" id="displayMessage"></div>
                <div className="text-center">
                    {!showingResults ? (
                        <img src="/images/illustrations/Mental Therapy.gif" alt="ABC" width="300px" />
                    ) : (<></>)}
                    <div className="card">
                        <div className="card-body">
                            <div className="row">
                                <div className="col">
                                    <input type="text" className="form-control" placeholder="Doctor/Clinic Name" id="keyword" onKeyDown={handleKeyPress} />
                                </div>
                                <div className="col-auto">
                                    <a href="/" className="btn btn-primary px-5" onClick={search}>Search</a>
                                </div>
                            </div>

                            <div className="row mt-3">
                                <div className="col">
                                    <select className="form-control" id="city">
                                        <option value="none">City</option>
                                        {cities.map((city) => (
                                            <option value={city}>{city}</option>
                                        ))}
                                    </select>
                                </div>
                                <div className="col">
                                    <select className="form-control" id="title">
                                        <option value="none">Title</option>
                                        {titles.map((title) => (
                                            <option value={title}>{title}</option>
                                        ))}
                                    </select>
                                </div>
                                <div className="col">
                                    <select className="form-control" id="specialty">
                                        <option value="none">Specialty</option>
                                        {specialties.map((specialty) => (
                                            <option value={specialty}>{specialty}</option>
                                        ))}
                                    </select>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>


                <div className="results mt-3">
                    <hr/>
                    {showingResults ? (
                        <>
                        <div>
                            {totalResults} Results Found - Page {currentPage+1} <span className="text-muted">(of {Math.ceil(totalResults/10)})</span>
                            {results.map((result) => (
                                <Result details={result} />
                            ))}
                        </div>
                        <div className="text-center mt-3">
                            <button className="result-button result-button-primary" onClick={()=>search("prev")}>Previous Page</button>
                            <button className="result-button result-button-primary" onClick={()=>search("next")}>Next Page</button>
                        </div>
                        </>
                    ) : (<></>)}
                </div>
            </div>
        </div>
    )
}