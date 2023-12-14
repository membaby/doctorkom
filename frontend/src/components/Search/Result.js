import React from "react";
import './styles.css';

export default function Result( { details } ) {

    // DUMMY DATA
    let avatars = ["default-doctor-female.png", "default-doctor-male.png"];
    const rating = Math.floor(Math.random() * 5) + 1;
    const stars = [];
    for (let i = 0; i < rating; i++) {
        stars.push(
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="#FFD700" class="bi bi-star-fill" viewBox="0 0 20 20">
                <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
            </svg>);
    }
    const totalResults = Math.floor(Math.random() * 100) + 1;
    const fees = Math.floor(Math.random() * 200) + 1;

    return (<>
        <div className="result mt-2">
            <div className="row">
                <div className="col-auto">
                    <img src={`/images/avatar/${details.systemUser.gender === "MALE" ? avatars[1] : avatars[0]}`} alt="Doctor" className="avatar" width="150px" />
                </div>
                <div className="col">
                    <div className="row">
                        <div className="col">
                            <div className="doctor-name">Dr. {details.systemUser.firstName + " " + details.systemUser.lastName}</div>
                            <div className="info"><span>{details.title}</span> • <span>{details.specialty.replace("_", " ")}</span></div>
                            <div className="address">{details.systemUser.address}</div>
                        </div>
                        <div className="col text-end">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                                    <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                                </svg>
                                <span className="mx-2 text-muted">+1 {details.systemUser.landlinePhone}</span>
                            </div>
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-phone" viewBox="0 0 16 16">
                                    <path d="M11 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM5 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
                                    <path d="M8 14a1 1 0 1 0 0-2 1 1 0 0 0 0 2"/>
                                </svg>
                                <span className="mx-2 text-muted">+1 {details.systemUser.mobilePhone}</span>
                            </div>
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
                                    <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"/>
                                </svg>
                                <a className="mx-2 text-muted" href={"mailto:"+details.systemUser.account.email}>Send Email</a>
                            </div>
                        </div>
                    </div>
                    <hr/>

                    <div className="row">
                        <div className="col-auto">
                            {stars}
                        </div>
                        •
                        <div className="col-auto">
                            <div className="reviews">{totalResults} Reviews</div>
                        </div>
                        •
                        <div className="col-auto">
                            <div className="fees">Fees: <b>${fees}</b></div>
                        </div>
                        {/* <div className="col">
                            <select className="form-control w-75" id="clinic">
                                {details.clinics.map((clinic) => (
                                    <option value={clinic}>{clinic}</option>
                                ))}
                            </select>
                        </div> */}
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