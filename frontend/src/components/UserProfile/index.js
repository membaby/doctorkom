import React, { useEffect } from 'react';
// import axios from 'axios';
import './styles.css'

const UserProfilePage = ({ userType }) => {

  useEffect(() => {
    if (userType !== 'patient' && userType !== 'doctor') {
      window.location.href = '/login';
    }
  }, []);

  const handleSaveChanges = () => {
    const data = {
      user_id: 0,
      firstname: document.getElementById('userprofile-fname').value,
      lastname: document.getElementById('userprofile-lname').value,
      email: document.getElementById('userprofile-email').value,
      gender: document.getElementById('userprofile-gender').value,
      birthdate: document.getElementById('userprofile-date').value,
      address: document.getElementById('userprofile-address').value,
      phone: document.getElementById('userprofile-phone').value,
      maritalstatus: document.getElementById('userprofile-maritalstatus') ? document.getElementById('userprofile-maritalstatus').value : null,
      occupation: document.getElementById('userprofile-occupation') ? document.getElementById('userprofile-occupation').value : null,
      insurance: document.getElementById('userprofile-insurance') ? document.getElementById('userprofile-insurance').value : null,
      title: document.getElementById('userprofile-title') ? document.getElementById('userprofile-title').value : null,
      speciality: document.getElementById('userprofile-speciality') ? document.getElementById('userprofile-speciality').value : null,
    }
    console.log(data);
  }

  return (
    <div class="container py-4 py-xl-5">
      <h3>User Profile Page</h3>
      <hr/>
      <div class="row">
        <div class="col-9">
          <h6 class="text-secondary">General Information</h6>
          <div class="card p-3">

            <div class="row">
              <div class="col">
                <span class="text-secondary">First name</span>
                <input type="text" class="form-control" id="userprofile-fname"/>
              </div>
              <div class="col">
                <span class="text-secondary">Last name</span>
                <input type="text" class="form-control" id="userprofile-lname"/>
              </div>
            </div>

            <div class="row mt-3">
              <div class="col">
                <span class="text-secondary">Username</span>
                <input type="text" class="form-control" id="userprofile-uname" disabled/>
              </div>
              <div class="col">
                <span class="text-secondary">Email address</span>
                <input type="email" class="form-control" id="userprofile-email"/>
              </div>
            </div>

            <div class="row mt-3">
              <div class="col">
                <span class="text-secondary">Gender</span>
                <select className="form-select" id="userprofile-gender" >
                    <option value="">Select</option>
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                </select>
              </div>
              <div class="col">
                <span class="text-secondary">Birthdate</span>
                <input type="date" class="form-control" id="userprofile-date"/>
              </div>
            </div>

            <div class="row mt-3">
              <div class="col">
                <span class="text-secondary">Address</span>
                <input type="text" class="form-control" id="userprofile-address"/>
              </div>
              <div class="col">
                <span class="text-secondary">Phone</span>
                <input type="text" class="form-control" id="userprofile-phone"/>
              </div>
            </div>

          </div>

          <h6 class="text-secondary mt-3">Specified Information</h6>
          <div class="card p-3">
            {userType === 'patient' ? (
              <>
                <div>
                  <span class="text-secondary">Marital Status</span>
                  <select className="form-select" id="userprofile-maritalstatus" >
                    <option value="">Select</option>
                    <option value="single">Single</option>
                    <option value="married">Married</option>
                    <option value="divorced">Divorced</option>
                    <option value="widowed">widowed</option>
                  </select>
                </div>
                <div>
                  <span class="text-secondary">Occupation</span>
                  <input type="text" class="form-control" id="userprofile-occupation"/>
                </div>
                <div>
                  <span class="text-secondary">Insurance</span>
                  <input type="text" class="form-control" id="userprofile-insurance"/>
                </div>
              </>
            ) : (
              <>
                <span class="text-secondary">Title</span>
                <select className="form-select" id="userprofile-title" >
                  <option value="">Select</option>
                  <option value="PROFESSOR">PROFESSOR</option>
                  <option value="LECTURER">LECTURER</option>
                  <option value="CONSULTANT">CONSULTANT</option>
                  <option value="SPECIALIST">SPECIALIST</option>
                </select>
                <span class="text-secondary">Speciality</span>
                <select className="form-select" id="userprofile-speciality" >
                  <option value="">Select</option>
                  <option value="GENERAL_PRACTITIONER">GENERAL_PRACTITIONER</option>
                  <option value="CARDIOLOGIST">CARDIOLOGIST</option>
                  <option value="DERMATOLOGIST">DERMATOLOGIST</option>
                  <option value="PEDIATRICIAN">PEDIATRICIAN</option>
                  <option value="ORTHOPEDIC_SURGEON">ORTHOPEDIC_SURGEON</option>
                  <option value="GYNECOLOGIST">GYNECOLOGIST</option>
                  <option value="OPHTHALMOLOGIST">OPHTHALMOLOGIST</option>
                  <option value="NEUROLOGIST">NEUROLOGIST</option>
                  <option value="UROLOGIST">UROLOGIST</option>
                  <option value="ENT_SPECIALIST">ENT_SPECIALIST</option>
                  <option value="PSYCHIATRIST">PSYCHIATRIST</option>
                  <option value="ONCOLOGIST">ONCOLOGIST</option>
                  <option value="RADIOLOGIST">RADIOLOGIST</option>
                  <option value="ANESTHESIOLOGIST">ANESTHESIOLOGIST</option>
                  <option value="DENTAL_SURGEON">DENTAL_SURGEON</option>
                </select>
              </>
            )}

            </div>
        </div>
        <div class="col">
          <h6 class="text-secondary">Profile Picture</h6>
          <div class="card p-3">
            {userType === 'patient' ? (
              <img src="/images/avatar/default-patient.png" class="m-auto" width="250px"></img>
            ) : (
              <img src="/images/avatar/default-doctor-female.png" class="m-auto" width="250px"></img>
            )}
            <input type="file" class="form-control mt-3" id="userprofile-picture"/>
          </div>
          <h6 class="text-secondary mt-3">Password</h6>
          <div class="card p-3">
            <div>
              <span class="text-secondary">New password</span>
              <input type="password" class="form-control" id="userprofile-password"/>
            </div>
            <div class="mt-2">
              <span class="text-secondary">Confirm password</span>
              <input type="password" class="form-control" id="userprofile-confirmpassword"/>
            </div>
          </div>

          <div class=" mt-2">
            <button type="button" class="btn btn-success w-100" onClick={handleSaveChanges}>Save Changes</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserProfilePage;