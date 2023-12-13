import React from "react";
import './styles.css';

export default function Result( { details } ) {

    // DEMO AVATAR
    let avatars = ["default-doctor-female.png", "default-doctor-male.png", "default-patient.png"];
    console.log(details);

    return (<>
        <div className="result mt-2">
            <div className="row">
                <div className="col-auto">
                    <img src={"/images/avatar/"+avatars[Math.floor(Math.random() * avatars.length)]} alt="Doctor" className="avatar" width="150px" />
                </div>
                <div className="col">
                    <div className="doctor-name">Dr. {details.name}</div>
                    <div className="info"><span>{details.title}</span> • <span>{details.specialty.replace("_", " ")}</span></div>
                    <div className="address">{details.address}</div>
                    <hr/>

                    <div className="row">
                        <div className="col-auto">
                            <div className="rating">{details.rating}</div>
                        </div>
                        <div className="col-auto">
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="#FFD700" class="bi bi-star-fill" viewBox="0 0 20 20">
                                <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="#FFD700" class="bi bi-star-fill" viewBox="0 0 20 20">
                                <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="#FFD700" class="bi bi-star-fill" viewBox="0 0 20 20">
                                <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="#FFD700" class="bi bi-star-fill" viewBox="0 0 20 20">
                                <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="#FFD700" class="bi bi-star-fill" viewBox="0 0 20 20">
                                <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                            </svg>
                        </div>
                        <div className="col-auto">
                            <div className="reviews">{details.reviews} Reviews</div>
                        </div>
                        <div className="col">
                            <select className="form-control w-75" id="clinic">
                                {details.clinics.map((clinic) => (
                                    <option value={clinic}>{clinic}</option>
                                ))}
                            </select>
                        </div>
                    </div>              
                </div>

                <div className="col-auto mx-1">
                    <div className="result-buttons">
                        <button className="result-button result-button-primary">Visit Page</button>
                        <button className="result-button result-button-secondary">Book</button>
                        <button className="result-button result-button-tertiary">Contact</button>
                    </div>
                </div>

            </div>
        </div>

    </>)
}