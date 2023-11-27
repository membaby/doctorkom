import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useGoogleLogin } from '@react-oauth/google';
import './styles.css'
import Select from 'react-select';


const RegisterD = () => {
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
  const [speciality, setSpeciality] = useState('');
  const [title, setTitle] = useState('');

  const handleFirstNameChange = (event) => {
    setFirstName(event.target.value);
    // console.log(firstName);
  };

  const handleLastNameChange = (event) => {
    setLastName(event.target.value);
    // console.log(lastName);
  };

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
    // console.log(email);
  };
  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
    // console.log(username);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
    // console.log(password);
  };

  const handleLandlineChange = (event) => {
    setLandline(event.target.value);
    // console.log(landline);
  };



  const handleAddressChange = (event) => {
    setAddress(event.target.value);
    // console.log(address);
  };

  const handleGenderChange = (event) => {
    setGender(event.target.value);
    // console.log(gender);
  };

  const handleBirthdateChange = (event) => {
    setBirthdate(event.target.value);
    // console.log(birthdate);
  };
 
  const handlePhoneChange = (event) => {
    setPhone(event.target.value);
    // console.log(phone);
  };

  const handleSpecialityChange = (event) => {
    setSpeciality(event.target.value);
    console.log(speciality);
  };

  const handleTitleChange = (event) => {
    setTitle(event.target.value);
    console.log(title);
  };
 




  const [ user, setUser ] = useState([]);
  const [ profile, setProfile ] = useState([]);

  const login = useGoogleLogin({
      onSuccess: (codeResponse) => {console.log(codeResponse);setUser(codeResponse)}
      ,
      onError: (error) => console.log('Login Failed:', error)
  });

  useEffect(
      () => {
          if (user) {
              axios
                  .get(`https://www.googleapis.com/oauth2/v1/userinfo?access_token=${user.access_token}`, {
                      headers: {
                          Authorization: `Bearer ${user.access_token}`,
                          Accept: 'application/json'
                      }
                  })
                  .then((res) => {
                      setProfile(res.data);
                      console.log(res.data);
                  })
                  .catch((err) => console.log(err));
          }
      },
      [ user ]
  );

  const handleRegister = () => {
    const account = {
      email: email,
      username: username,
      password: password,
      role: "doctor"
    };
  
    const systemUser = {
      firstName: firstName,
      lastName: lastName,
      birthdate: birthdate,
      gender: gender, 
      address: address,
      mobile: phone,
      landline: landline,
      account:account
    };
     const Doctor={
    
    title:title,
    speciality:speciality,
    systemUser : systemUser
    };
  
    console.log(account)

    fetch('', { ////
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(Doctor),
    })
    .then(response => response.json())
    .then(Patient=> {
        if (Patient.success) {
            window.location.href = '/verification';
        } else {
            // showError(patient.message);
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

  return (
    <>
    <div className="card mx-auto mt-5" style={{ maxWidth: '1000px' }}>
      <div className="card-body">
        <h2 className="card-title text-center mb-4">Registration</h2>
       
        <form>
       
        <div className="row">
          <div className="col mb-3">
            <label htmlFor="firstName" className="form-label">
              First Name
            </label>
            <input
              type="text"
              id="firstName"
              className="form-control"
              value={firstName}
              onChange={handleFirstNameChange}
            />
          </div>
          <div className="col mb-3">
            <label htmlFor="lastName" className="form-label">
              Last Name
            </label>
            <input
              type="text"
              id="lastName"
              className="form-control"
              value={lastName}
              onChange={handleLastNameChange}
            />
          </div>
          <div className="col mb-3">
            <label htmlFor="email" className="form-label">
              Email
            </label>
            <input
              type="text"
              id="email"
              className="form-control"
              value={email}
              onChange={handleEmailChange}
            />
          </div>
        </div>






          <div className="row">
            <div className="col mb-3">
              <label htmlFor="username" className="form-label">
                Username
              </label>
              <input
                type="username"
                id="username"
                className="form-control"
                value={username}
                onChange={handleUsernameChange}
              />
            </div>
            <div className="col mb-3">
              <label htmlFor="password" className="form-label">
                Password
              </label>
              <input
                type="password"
                id="password"
                className="form-control"
                value={password}
                onChange={handlePasswordChange}
              />
            </div>
                <div className="col mb-3">
                <label htmlFor="gender" className="form-label">
                  Gender
                </label>
                <select
                  className="form-select"
                  aria-label="Default select example"
                  id="gender"
                  value={gender}
                  onChange={handleGenderChange}
                >
                  <option value="">Select</option>
                  <option value="female">Female</option>
                  <option value="male">Male</option>
                </select>
              </div>
          </div>


  <div className="row">  


<div className="col mb-3">
  <label htmlFor="birthdate" className="form-label">
    Birthdate
  </label>
  <input
    className="form-control"
    id="birthdate"
    type="date"
    value={birthdate}
    onChange={handleBirthdateChange}
  />
</div>
<div className="col mb-3">
              <label htmlFor="address" className="form-label">
                Address
              </label>
              <input
                type="text"
                id="address"
                className="form-control"
                value={address}
                onChange={handleAddressChange}
              />

             
            </div>
            <div className="col mb-3">
              <label htmlFor="landline" className="form-label">
                Landline
              </label>
              <input
                type="text"
                id="landline"
                className="form-control"
                value={landline}
                onChange={handleLandlineChange}
              />
            </div>
    </div>
         
          <div className="row">
            <div className="col mb-3">
              <label htmlFor="phone" className="form-label">
                Phone
              </label>
              <input
                type="tel"
                id="phone"
                className="form-control"
                value={phone}
                onChange={handlePhoneChange}
              />
            </div>
            <div className="col mb-3">
              <label htmlFor="speciality" className="form-label">
              Speciality
              </label>
              <input
                type="speciality"
                id="speciality"
                className="form-control"
                value={speciality}
                onChange={handleSpecialityChange}
              />
            </div>
            <div className="col mb-5">
                <label htmlFor="title" className="form-label">
                  Title
                </label>
                <select
                  className="form-select"
                  aria-label="Default select example"
                  id="title"
                  value={title}
                  onChange={handleTitleChange}
                >
                  <option value="">Select</option>
                  <option value="professor">PROFESSOR</option>
                  <option value="lecturer">LECTURER</option>
                  <option value="consultant">CONSULTANT</option>
                  <option value="specialist">SPECIALIST</option>
                </select>
              </div>
        
    
           
          </div>
       

          <div class="row">
            <div className="text-center col">
              <button className="btn btn-danger w-100" onClick={()=>{login()}} >
                Sign up with Google
              </button>
            </div>
            <div className="text-center col">
              <button className="btn btn-success w-100" onClick={handleRegister}>
                Register
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
   </>
  );
};

export default RegisterD;






