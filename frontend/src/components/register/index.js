import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useGoogleLogin } from '@react-oauth/google';
import './styles.css'
import { useLocation } from 'react-router-dom';

const Register = ({ userType }) => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [landline, setLandline] = useState('');
  const [phone, setPhone] = useState('');
  const [address, setAddress] = useState('');
  const [gender, setGender] = useState('');
  const [birthdate, setBirthdate] = useState('');
  // Patient Attributes
  const [maritalstatus, setMaritalstatus] = useState('');
  const [occupation, setOccupation] = useState('');
  const [insurance, setInsurance] = useState('');
  // Doctor Attributes
  const [speciality, setSpeciality] = useState('');
  const [title, setTitle] = useState('');
  // Special Invitiation Code
  const [invitiationCode, setInvitiationCode] = useState('');

  let location = useLocation();
  useEffect(() => {
    if (userType !== 'patient' && userType !== 'doctor') {
      const searchParams = new URLSearchParams(location.search);
      const invitiation_code = searchParams.get('invitation'); 
      if (invitiation_code) {
        setInvitiationCode(invitiation_code);
      } else {
        window.location.href = '/register/patient';
      }
    }
  }, []);

  const [user, setUser] = useState({});

  const googleRegister = useGoogleLogin({
    onSuccess: (codeResponse) => {
      setUser(codeResponse);
    },
    onError: (error) => console.log('Login Failed:', error),
  });

  useEffect(() => {
    if (user.access_token) { // Check if user object has the access_token property
      axios.get(`https://www.googleapis.com/oauth2/v1/userinfo`, {
        headers: {
          Authorization: `Bearer ${user.access_token}`, // Use Bearer format for OAuth
          Accept: 'application/json',
        },
      }).then((res) => {
        setFirstName(res.data.given_name);
        setLastName(res.data.family_name);
        setEmail(res.data.email);
        setUsername(res.data.id);
        setPassword("mchbomNZPYvmxbv0e3yNAy");
        setGender("MALE");
        handleRegister();
      }).catch((err) => console.log(err));
    }
  }, [user]); // Depend on user object

  const handleRegister = () => {
    const account = {
      email: email,
      username: username,
      password: password,
      role: userType === 'patient' ? 'PATIENT' : userType === 'doctor' ? 'DOCTOR' : userType === 'admin' ? 'SYSTEM_ADMIN' : userType === 'clinic' ? 'CLINIC_ADMIN' : ''
    };

  
    const systemUser = {
      firstName: firstName,
      lastName: lastName,
      birthdate: birthdate,
      gender: gender, 
      address: address,
      mobile: phone,
      landline: landline,
      account: account
    };

    const data = {
      systemUser: systemUser
    };

    if (password !== "GOOGLEAUTH") {
      if (!email || !username || !password || !firstName || !lastName || !birthdate || !gender || !address || !phone || !landline) {
        showError('Please fill all the fields');
        return;
      }
    }
    showError(null);

    if (userType === 'patient') {
      data.maritalstatus = maritalstatus;
      data.occupation = occupation;
      data.insurance = insurance
    } else if (userType === 'doctor') {
      data.title = title;
      data.speciality = speciality;
    } else if (invitiationCode) {
      data.invitiationCode = invitiationCode;
    }

    document.getElementById('display').innerHTML = 'Creating your account.. Please wait!';
    document.getElementById('display').style.display = 'block';
  
    fetch('http://localhost:8080/registration/' + userType, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(response => {
        if (response.success) {
          if (password === "mchbomNZPYvmxbv0e3yNAy") {
            window.location.href = '/profile';
          } else {
            window.location.href = '/verification';
          }
        } else {
            showError(response.msg);
        }
    })
    .catch((error) => {
        showError('Internal Server Error occured. Please try again later.')
    });
  }

  const showError = (msg) => {
    if (!msg) {
      const error = document.getElementById('display');
      error.style.display = 'none';
      return;
    }
    const error = document.getElementById('display');
    error.innerHTML = msg;
    error.style.display = 'block';
  }

  return (
    <div className="card mx-auto mt-5" style={{ maxWidth: '1000px' }}>
      <div className="card-body">
        <h2 className="card-title text-center mb-4">
          {
            userType === 'patient' ? 'Patient Registration' :
            userType === 'doctor' ? 'Doctor Registration' :
            userType === 'admin' ? 'Admin Registration' :
            userType === 'clinic' ? 'Clinic Registration' :
            ""
          }
        </h2>

        <div className="alert alert-primary" role="alert" id="display" style={{ display: 'none' }}></div>
       
        <form onSubmit={(e) => e.preventDefault()}>
        
          {/* Fields */}
          <div className="row">
            <div className="col mb-3">
              <label className="form-label">First Name</label>
              <input type="text" className="form-control" onChange={(e) => setFirstName(e.target.value)} />
            </div>

            <div className="col mb-3">
              <label className="form-label">Last Name</label>
              <input type="text" className="form-control" onChange={(e) => setLastName(e.target.value)} />
            </div>

            <div className="col mb-3">
              <label className="form-label">Email</label>
              <input type="email" className="form-control" onChange={(e) => setEmail(e.target.value)} />
            </div>
          </div>

          <div className="row">
            <div className="col mb-3">
              <label className="form-label">Username</label>
              <input type="text" className="form-control" onChange={(e) => setUsername(e.target.value)} />
            </div>

            <div className="col mb-3">
              <label className="form-label">Password</label>
              <input type="password" className="form-control" onChange={(e) => setPassword(e.target.value)} />
            </div>

            <div className="col mb-3">
              <label className="form-label">Gender</label>
              <select className="form-select" onChange={(e) => setGender(e.target.value)} >
                    <option value="">Select</option>
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                </select>
            </div>
          </div>

          <div className="row">
            <div className="col mb-3">
              <label className="form-label">Brithdate</label>
              <input type="date" className="form-control" onChange={(e) => setBirthdate(e.target.value)} />
            </div>

            <div className="col mb-3">
              <label className="form-label">Address</label>
              <input type="text" className="form-control" onChange={(e) => setAddress(e.target.value)} />
            </div>

            <div className="col mb-3">
              <label className="form-label">Landline</label>
              <input type="text" className="form-control" onChange={(e) => setLandline(e.target.value)} />
            </div>
          </div>

          {userType === 'patient' ? (<>
            <div className="row">
              <div className="col mb-3">
                <label className="form-label">Phone</label>
                <input type="text" className="form-control" onChange={(e) => setPhone(e.target.value)} />
              </div>

              <div className="col mb-3">
                <label className="form-label">Marital Status</label>
                <select className="form-select" onChange={(e) => setMaritalstatus(e.target.value)} >
                    <option value="">Select</option>
                    <option value="single">Single</option>
                    <option value="married">Married</option>
                    <option value="divorced">Divorced</option>
                    <option value="widowed">widowed</option>
                </select>
              </div>

              <div className="col mb-3">
                <label className="form-label">Occupation</label>
                <input type="text" className="form-control" onChange={(e) => setOccupation(e.target.value)} />
              </div>
            </div>

            <div className="row">
              <div className="col mb-3">
                <label className="form-label">Insurance</label>
                <input type="text" className="form-control" onChange={(e) => setInsurance(e.target.value)} />
              </div>
            </div>
          </>) : userType === 'doctor' ? (<>
            <div className="row">
              <div className="col mb-3">
                <label className="form-label">Phone</label>
                <input type="text" className="form-control" onChange={(e) => setPhone(e.target.value)} />
              </div>

              <div className="col mb-3">
                <label className="form-label">Title</label>
                <select className="form-select" onChange={(e) => setTitle(e.target.value)} >
                  <option value="">Select</option>
                  <option value="PROFESSOR">PROFESSOR</option>
                  <option value="LECTURER">LECTURER</option>
                  <option value="CONSULTANT">CONSULTANT</option>
                  <option value="SPECIALIST">SPECIALIST</option>
                </select>
              </div>

              <div className="col mb-3">
                <label className="form-label">Speciality</label>
                <input type="text" className="form-control" onChange={(e) => setSpeciality(e.target.value)} />
              </div>
            </div>
          </>) : (<></>)
          }

          {/* Buttons */}
          <div className="row mt-3">
            <div className="col mb-3">
            <button className="btn btn-success w-100" onClick={handleRegister}>Register</button>
            </div>
            <div className="col mb-3">
              <button className="btn btn-danger w-100" onClick={()=>{googleRegister()}} >Sign up with Google</button>
            </div>
          </div>

        </form>
      </div>
    </div>
   
  );
};

export default Register;