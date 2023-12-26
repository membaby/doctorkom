import React from "react";
import { useEffect  } from "react";
import { useLocation } from "react-router-dom";
import getUserInfo from "../../functions/getUserInfo";
import 'bootstrap/dist/css/bootstrap.min.css';
import "./styles.css";

export default function DoctorDetails() {

  const location = useLocation();
  const username = location.pathname.split("/")[2];
  const [doctor, setDoctor] = React.useState({
    "id": 197,
    "title": "LECTURER",
    "specialty": "CARDIOLOGIST",
    "systemUser": {
        "id": 197,
        "firstName": "Interesting",
        "lastName": "Agnesi",
        "birthdate": "1962-05-19",
        "gender": "FEMALE",
        "address": "942 Lewis Road, CA, 95076",
        "mobilePhone": "5250867004",
        "landlinePhone": "4984144684",
        "account": {
            "id": 197,
            "email": "interesting_agnesi@gmail.com",
            "username": "interesting_agnesi",
            "password": "15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225",
            "role": "DOCTOR"
        }
    }
});

const rating = [5, 2, 1, 0, 0];
const ratingAverage = rating.reduce((a, b) => a + b, 0) / rating.length;

  
  useEffect(() => {
    getUserInfo("DOCTOR", username)
      .then((data) => {
        setDoctor(data);
      })
      .catch((error) => {
        console.error("Error fetching doctor info:", error);
      });
  }, []);
  let avatars = ["default-doctor-female.png", "default-doctor-male.png"];


    return (
        <div>
          {doctor ? (
            <>
              <div class="container py-4 py-xl-5">
                  <div className="row">
                    <div className="col-auto">
                    <img src={`/images/avatar/${doctor.systemUser.gender === "MALE" ? avatars[1] : avatars[0]}`} alt="Doctor" className="avatar" width="150px" />
                    </div>
                    <div className="col verticalcenter">
                      <h2>{doctor.systemUser.firstName} {doctor.systemUser.lastName}</h2>
                      <h6>{doctor.title} • {doctor.specialty}</h6>
                      <div className="text-muted">{doctor.systemUser.address}</div>
                    </div>
                    <div className="col-auto verticalcenter">
                      
                      <div>
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                              <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                          </svg>
                          <span className="mx-2 text-muted">+1 {doctor.systemUser.landlinePhone}</span>
                      </div>
                      <div>
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-phone" viewBox="0 0 16 16">
                              <path d="M11 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM5 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
                              <path d="M8 14a1 1 0 1 0 0-2 1 1 0 0 0 0 2"/>
                          </svg>
                          <span className="mx-2 text-muted">+1 {doctor.systemUser.mobilePhone}</span>
                      </div>
                      <div>
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
                              <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"/>
                          </svg>
                          <a className="mx-2 text-muted" href={"mailto:"+doctor.systemUser.account.email}>Send Email</a>
                      </div>

                      
                    </div>
                  </div>
                  <hr/>

                  <div className="row">
                    <div className="col">
                      <div className="h6">About Dr. {doctor.systemUser.lastName}</div>
                      <p>Welcome to the profile of Dr. {doctor.systemUser.lastName}. With a commitment to excellence in patient care, Dr. {doctor.systemUser.lastName} is a seasoned medical professional dedicated to providing comprehensive healthcare services. Known for their expertise in {doctor.specialty}, Dr. {doctor.systemUser.lastName} brings a wealth of knowledge and experience to their practice.</p>
                      <div className="h6">Education and Qualifications</div>
                      <p>{doctor.systemUser.firstName} {doctor.systemUser.lastName} graduated from Medical School with honors and has pursued further specialization in {doctor.specialty}. They are board-certified and stays abreast of the latest advancements in their field through continuous education and professional development.</p>
                      <div className="h6">Professional Memberships</div>
                      <p>Dr. {doctor.systemUser.lastName} is an active member, contributing to the advancement of healthcare practices and maintaining connections with peers in the medical community.</p>
                    </div>
                    <div className="col">
                      <div className="h5">Available Times</div>
                      <div className="table-container">
                        <table className="table table-striped table-hover">
                          <thead>
                            <th>Date/Time</th>
                            <th>Duration</th>
                            <th>Clinic Name</th>
                            <th>Action</th>
                          </thead>
                          <tbody>
                            <tr>
                              <td>2021-05-01 10:00</td>
                              <td>30 min</td>
                              <td>ICP</td>
                              <td><button className="btn btn-primary">Book</button></td>
                            </tr>
                            <tr>
                              <td>2021-05-01 10:00</td>
                              <td>30 min</td>
                              <td>ICP</td>
                              <td><button className="btn btn-primary">Book</button></td>
                            </tr>
                            <tr>
                              <td>2021-05-01 10:00</td>
                              <td>30 min</td>
                              <td>ICP</td>
                              <td><button className="btn btn-primary">Book</button></td>
                            </tr>
                            <tr>
                              <td>2021-05-01 10:00</td>
                              <td>30 min</td>
                              <td>ICP</td>
                              <td><button className="btn btn-primary">Book</button></td>
                            </tr>
                            <tr>
                              <td>2021-05-01 10:00</td>
                              <td>30 min</td>
                              <td>ICP</td>
                              <td><button className="btn btn-primary">Book</button></td>
                            </tr>
                            <tr>
                              <td>2021-05-01 10:00</td>
                              <td>30 min</td>
                              <td>ICP</td>
                              <td><button className="btn btn-primary">Book</button></td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>

                  <hr/>

                  <div class="row mt-3">
                            <div class="col">
                                <span class="text-bold">Bewertungen</span>
                                    {rating.map((item, index) => (
                                        <div class="row mt-2">
                                            <span class="progress-type col-auto">{5-index}</span>
                                            <div class="progress col text-center">
                                                <div class="progress-bar" style={{width: `${item * 20}%`}} role="progressbar" aria-valuenow={item} aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    ))}
                            </div>
                            <div class="col-auto text-center">
                              <div className="px-5">
                                <span class="rating2 text-muted">4,5</span>
                                <br/>
                                {Array.from({ length: 5 }, (_, index) => (
                                    <svg
                                        key={index}
                                        xmlns="http://www.w3.org/2000/svg"
                                        width="16"
                                        height="16"
                                        fill= {(Math.ceil(4) > index && ("#2826A7")) || "#6c757d" }
                                        className="bi bi-star-fill m-1"
                                        viewBox="0 0 16 16"
                                    >
                                        <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z" />
                                    </svg>
                                ))}
                                <br/>
                                <span class="rating-count text-muted">123 Reviews</span>
                              </div>
                            </div>
                        </div>

                  
                  <hr/>

                  <div class="row">
                      <div class="col-auto">
                          <a class="profile-info" target="_blank" href="https://goo.gl/maps/w5vdEkDopRWHudye9" rel="noreferrer">
                              <u>Directions to {doctor.systemUser.address}</u>
                          </a>
                      </div>
                      <iframe class="googlemap" src={"https://maps.google.com/maps?hl=en&q=" + doctor.systemUser.address + "&t=&z=12&ie=UTF8&iwloc=B&output=embed"} title="Google Maps"></iframe>
                  </div>

              </div>
            </>
          ) : (
            <>
            <div class="container py-4 py-xl-5">
              <h3>Loading...</h3>
            </div>
            </>
          )}
        </div>
    )
}