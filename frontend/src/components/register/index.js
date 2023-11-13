import React, { useState } from 'react';
import './styles.css'
const Register = () => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [governorate, setGovernorate] = useState('');
  const [address, setAddress] = useState('');
  const [phone, setPhone] = useState('');

  const handleFirstNameChange = (event) => {
    setFirstName(event.target.value);
  };

  const handleLastNameChange = (event) => {
    setLastName(event.target.value);
  };

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleGovernorateChange = (event) => {
    setGovernorate(event.target.value);
  };

  const handleAddressChange = (event) => {
    setAddress(event.target.value);
  };

  const handlePhoneChange = (event) => {
    setPhone(event.target.value);
  };

  const handleRegister = () => {
    let Registerdata = {
      firstName:firstName,
      lastName:lastName,
      emial:email,
      password:password,
      governorate:governorate,
      address:address,
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
              <label htmlFor="governorate" className="form-label">
                Governorate
              </label>
              <input
                type="text"
                id="governorate"
                className="form-control"
                value={governorate}
                onChange={handleGovernorateChange}
              />
            </div>
            <div className="col-md-6 mb-3">
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
          <div className="text-center">
            <button className="btn btn-success " onClick={handleRegister}>
              Register
            </button>
          </div>
        </form>
      </div>
    </div>
   
  );
};

export default Register;
