import React, { useState } from "react";
import Result from "./Result";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function Search() {

    const cities = ['Alexandria', 'Cairo', 'Giza', 'Ismailia', 'Luxor', 'Port Said', 'Suez', 'Aswan', 'Asyut', 'Beheira', 'Beni Suef', 'Dakahlia', 'Damietta', 'Faiyum', 'Gharbia', 'Kafr El Sheikh', 'Matruh', 'Minya', 'Monufia', 'New Valley', 'North Sinai', 'Qalyubia', 'Qena', 'Red Sea', 'Sharqia', 'Sohag', 'South Sinai', '6th of October'];
    const titles = ['PROFESSOR', 'LECTURER', 'CONSULTANT', 'SPECIALIST'];
    const specialties = ['GENERAL_PRACTITIONER', 'CARDIOLOGIST', 'DERMATOLOGIST', 'PEDIATRICIAN', 'ORTHOPEDIC_SURGEON', 'GYNECOLOGIST', 'OPHTHALMOLOGIST', 'NEUROLOGIST', 'UROLOGIST', 'ENT_SPECIALIST', 'PSYCHIATRIST', 'ONCOLOGIST', 'RADIOLOGIST', 'ANESTHESIOLOGIST', 'DENTAL_SURGEON'];

    const [showingResults, setShowingResults] = useState(false);
    const [results, setResults] = useState([]);
    const [totalResults, setTotalResults] = useState(0);
    const [currentPage, setCurrentPage] = useState(1);

    const search = () => {
        const city = document.getElementById('city').value;
        const title = document.getElementById('title').value;
        const specialty = document.getElementById('specialty').value;
        const keyword = document.getElementById('keyword').value;

        // DEMO
        setResults([
            { name: 'Dr. Ahmed', title: 'PROFESSOR', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] },
            { name: 'Dr. Mohamed', title: 'LECTURER', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] },
            { name: 'Dr. Ali', title: 'CONSULTANT', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] },
            { name: 'Dr. Mahmoud', title: 'SPECIALIST', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] },
            { name: 'Dr. Ahmed', title: 'PROFESSOR', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] },
            { name: 'Dr. Mohamed', title: 'LECTURER', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] },
            { name: 'Dr. Ali', title: 'CONSULTANT', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] },
            { name: 'Dr. Mahmoud', title: 'SPECIALIST', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] }
        ]);
        setTotalResults(8);

        setShowingResults(true);
    }

    return (
        <div>
            <div class="container py-4 py-xl-5">
                <h3>Find Your Ideal Healthcare Provider</h3>
                <hr/>
                {/* <div className="text-center">
                    {!showingResults ? (
                        <img src="/images/illustrations/Mental Therapy.gif" alt="ABC" width="300px" />
                    ) : (<></>)}
                    <div className="card">
                        <div className="card-body">
                            <div className="row">
                                <div className="col">
                                    <input type="text" className="form-control" placeholder="Doctor/Clinic Name" id="keyword" />
                                </div>
                                <div className="col-auto">
                                    <a href="#" className="btn btn-primary px-5" onClick={search}>Search</a>
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
                </div> */}


                <div className="results mt-3">
                <Result result={{ name: 'Dr. Ahmed', title: 'PROFESSOR', specialty: 'GYNECOLOGIST', city: 'Cairo', address: 'El Haram', rating: 4.5, reviews: 100, clinics: ['El Haram Clinic', 'El Haram Clinic 2'] }} />
                    <hr/>
                    {/* {totalResults} Results Found */}
                    {showingResults ? (
                        <div>
                            {results.map((result) => (
                                <Result result={result} />
                            ))}
                        </div>
                    ) : (<></>)}
                </div>

            </div>
        </div>
    )
}