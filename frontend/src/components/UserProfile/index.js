import React, { useEffect, useState } from 'react';
import Cookies from 'universal-cookie';
import getUserInfo from '../../functions/getUserInfo';
import setUserInfo from '../../functions/setUserInfo';
import hashString from '../../functions/hashString';
import './styles.css'

const UserProfilePage = () => {
  const [userType, setUserType] = useState(null);
  const [userData, setUserData] = useState(null);
  const [displayMessage, setDisplayMessage] = useState("");
  const [formEnabled, setFormEnabled] = useState(false);

  useEffect(() => {
    const cookies = new Cookies();
    const role = cookies.get('role');
    const username = cookies.get('username');
    
    if (role && (role === "PATIENT" || role === "DOCTOR")) {
      setUserType(role);
    } else {
      window.location.href = '/login';
    }
    setDisplayMessage('Profile data is loading... please wait')
    setFormEnabled(false);
    getUserInfo(role, username)
    .then(data => {
      setUserData(data);
      setDisplayMessage('')
      setFormEnabled(true);
    })

  }, []);

  const updateProfileInfo = () => {
    const data = userData;
    userData.systemUser.firstName = document.getElementById('userprofile-fname').value;
    userData.systemUser.lastName = document.getElementById('userprofile-lname').value;
    userData.systemUser.account.email = document.getElementById('userprofile-email').value;
    userData.systemUser.gender = document.getElementById('userprofile-gender').value;
    userData.systemUser.birthdate = document.getElementById('userprofile-date').value;
    userData.systemUser.address = document.getElementById('userprofile-address').value;
    userData.systemUser.mobilePhone = document.getElementById('userprofile-phone').value;
    if (userType === "PATIENT") {
      userData.maritialStatus = document.getElementById('userprofile-maritalstatus').value;
      userData.occupation = document.getElementById('userprofile-occupation').value;
      userData.insurance = document.getElementById('userprofile-insurance').value;
    } else if (userType === "DOCTOR") {
      userData.title = document.getElementById('userprofile-title').value;
      userData.specialty = document.getElementById('userprofile-speciality').value;
    }
    
    const password = document.getElementById('userprofile-password').value;
    const confirmpassword = document.getElementById('userprofile-confirmpassword').value;
    if (password && confirmpassword && password === confirmpassword) {
      userData.systemUser.account.password = hashString(password);
    }

    setDisplayMessage('Profile data is updating...');
    setFormEnabled(false);
    setUserInfo(userType, data)
    .then(data => {
      setDisplayMessage("Profile data updated successfully!");
      setFormEnabled(true);
    })
  }

  useEffect(() => {
    if (userData) {
      document.getElementById('userprofile-fname').value = userData.systemUser.firstName;
      document.getElementById('userprofile-lname').value = userData.systemUser.lastName;
      document.getElementById('userprofile-email').value = userData.systemUser.account.email;
      document.getElementById('userprofile-gender').value = userData.systemUser.gender;
      document.getElementById('userprofile-date').value = userData.systemUser.birthdate;
      document.getElementById('userprofile-address').value = userData.systemUser.address;
      document.getElementById('userprofile-phone').value = userData.systemUser.mobilePhone;
      document.getElementById('userprofile-uname').value = userData.systemUser.account.username;
      if (userType === "PATIENT") {
        document.getElementById('userprofile-maritalstatus').value = userData.maritialStatus;
        document.getElementById('userprofile-occupation').value = userData.occupation;
        document.getElementById('userprofile-insurance').value = userData.insurance;
      } else if (userType === "DOCTOR") {
        document.getElementById('userprofile-title').value = userData.title;
        document.getElementById('userprofile-speciality').value = userData.specialty;
      }
    }
}, [userData]);

  return (
    <div class="container py-4 py-xl-5">
      <h3>User Profile Page</h3>
      <hr/>
      <div className="alert">{displayMessage}</div>
      <div class="row">
        <div class="col-9">
          <h6 class="text-secondary">General Information</h6>
          <div class="card p-3">

            <div class="row">
              <div class="col">
                <span class="text-secondary">First name</span>
                <input type="text" class="form-control" id="userprofile-fname" disabled={!formEnabled} />
              </div>
              <div class="col">
                <span class="text-secondary">Last name</span>
                <input type="text" class="form-control" id="userprofile-lname" disabled={!formEnabled}/>
              </div>
            </div>

            <div class="row mt-3">
              <div class="col">
                <span class="text-secondary">Username</span>
                <input type="text" class="form-control" id="userprofile-uname" disabled/>
              </div>
              <div class="col">
                <span class="text-secondary">Email address</span>
                <input type="email" class="form-control" id="userprofile-email" disabled={!formEnabled}/>
              </div>
            </div>

            <div class="row mt-3">
              <div class="col">
                <span class="text-secondary">Gender</span>
                <select className="form-select" id="userprofile-gender" disabled={!formEnabled} >
                    <option value="">Select</option>
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                </select>
              </div>
              <div class="col">
                <span class="text-secondary">Birthdate</span>
                <input type="date" class="form-control" id="userprofile-date" disabled={!formEnabled}/>
              </div>
            </div>

            <div class="row mt-3">
              <div class="col">
                <span class="text-secondary">Address</span>
                <input type="text" class="form-control" id="userprofile-address" disabled={!formEnabled}/>
              </div>
              <div class="col">
                <span class="text-secondary">Phone</span>
                <input type="text" class="form-control" id="userprofile-phone" disabled={!formEnabled}/>
              </div>
            </div>

          </div>

          <h6 class="text-secondary mt-3">Specified Information</h6>
          <div class="card p-3">
            {userType === 'PATIENT' ? (
              <>
                <div>
                  <span class="text-secondary">Marital Status</span>
                  <select className="form-select" id="userprofile-maritalstatus" disabled={!formEnabled}>
                    <option value="">Select</option>
                    <option value="single">Single</option>
                    <option value="married">Married</option>
                    <option value="divorced">Divorced</option>
                    <option value="widowed">widowed</option>
                  </select>
                </div>
                <div>
                  <span class="text-secondary">Occupation</span>
                  <input type="text" class="form-control" id="userprofile-occupation" disabled={!formEnabled}/>
                </div>
                <div>
                  <span class="text-secondary">Insurance</span>
                  <input type="text" class="form-control" id="userprofile-insurance" disabled={!formEnabled}/>
                </div>
              </>
            ) : (
              <>
                <span class="text-secondary">Title</span>
                <select className="form-select" id="userprofile-title" disabled={!formEnabled}>
                  <option value="">Select</option>
                  <option value="PROFESSOR">PROFESSOR</option>
                  <option value="LECTURER">LECTURER</option>
                  <option value="CONSULTANT">CONSULTANT</option>
                  <option value="SPECIALIST">SPECIALIST</option>
                </select>
                <span class="text-secondary">Speciality</span>
                <select className="form-select" id="userprofile-speciality" disabled={!formEnabled}>
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
            {userType === 'PATIENT' ? (
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
            <button type="button" class="btn btn-success w-100" onClick={updateProfileInfo}>Save Changes</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserProfilePage;