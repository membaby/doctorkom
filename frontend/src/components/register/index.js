import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useGoogleLogin } from '@react-oauth/google';
import './styles.css'
import Select from 'react-select';


const Register = () => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [governorate, setGovernorate] = useState('');
  const [phone, setPhone] = useState('');
  const [country, setCountry] = useState('');
  const [gender, setGender] = useState('');
  const [birthdate, setBirthdate] = useState('');


  const handleFirstNameChange = (event) => {
    setFirstName(event.target.value);
    console.log(firstName);
  };

  const handleLastNameChange = (event) => {
    setLastName(event.target.value);
    console.log(lastName);
  };

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
    console.log(email);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
    console.log(password);
  };

  const handleGovernorateChange = (event) => {
    setGovernorate(event.target.value);
    console.log(governorate);
  };

  const handleCountryChange = (event) => {
    setCountry(event.target.value);
    console.log(country);
  };

  const handleGenderChange = (event) => {
    setGender(event.target.value);
    console.log(gender);
  };

  const handleBirthdateChange = (event) => {
    setBirthdate(event.target.value);
    console.log(birthdate);
  };
 
  const handlePhoneChange = (event) => {
    setPhone(event.target.value);
    console.log(phone);
  };




  const [ user, setUser ] = useState([]);
  const [ profile, setProfile ] = useState([]);

  const login = useGoogleLogin({
      onSuccess: (codeResponse) => setUser(codeResponse),
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
    let Registerdata = {
      firstName:firstName,
      lastName:lastName,
      emial:email,
      password:password,
      governorate:governorate,
      country:country,
      gender:gender,
      birthdate:birthdate,
      phone:phone
    }
    
    

    fetch('', { ////
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(Registerdata),
    })
    .then(response => response.json())
    .then(Registerdata => {
        if (Registerdata.success) {
            window.location.href = '/verification';
        } else {
            // showError(Registerdata.message);
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

  return (
    <div className="card mx-auto mt-5" style={{ maxWidth: '600px' }}>
      <div className="card-body">
        <h2 className="card-title text-center mb-4">Registration</h2>
       
        <form>
          <div className="row">
            <div className="col-md-6 mb-3">
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
            <div className="col-md-6 mb-3">
              <label htmlFor="lastName" className="form-label">
                Family Name
              </label>
              <input
                type="text"
                id="lastName"
                className="form-control"
                value={lastName}
                onChange={handleLastNameChange}
              />
            </div>
          </div>
          <div className="row">
            <div className="col-md-6 mb-3">
              <label htmlFor="email" className="form-label">
                Email
              </label>
              <input
                type="email"
                id="email"
                className="form-control"
                value={email}
                onChange={handleEmailChange}
              />
            </div>
            <div className="col-md-6 mb-3">
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
          </div>
          <div className="row">
    

<div className="col-md-6 mb-3">
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
<div className="col-md-6 mb-3">
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
          </div>
          <div className="row">
            <div className="col-md-6 mb-3">
              <label htmlFor="governorate" className="form-label">
                Country
              </label>
              <input
                type="text"
                id="country"
                className="form-control"
                value={country}
                onChange={handleCountryChange}
              />

             
            </div>
            <div className="col-md-6 mb-3">
              <label htmlFor="address" className="form-label">
                Governorate
              </label>
              <input
                type="text"
                id="address"
                className="form-control"
                value={governorate}
                onChange={handleGovernorateChange}
              />
            </div>
          </div>
          <div className="row">
            <div className="col-md-6 mb-3">
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
          </div>

          <div class="row">
            <div className="text-center col">
              <button className="btn btn-danger w-100" onClick={() => login()}>
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
   
  );
};

export default Register;






