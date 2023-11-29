import React, { useState, useEffect } from 'react';
// import axios from 'axios';
import { useLocation } from 'react-router-dom';

const Verification = () => {
  const [email, setEmail] = useState(null);
  const [code, setCode] = useState(null);
  let location = useLocation();

  const handleVerification = () => {

    const data = {
      email: email,
      code: code
    };
    
    if (!email || !code) {
      showError('Please fill all the fields');
      return;
    }
    showError(null);
    
    document.getElementById('display').innerHTML = 'Verifying your email.. Please wait!';
    document.getElementById('display').style.display = 'block';

    // window.location.href = '/';
    // return;
  
    fetch('http://localhost:8080/verify?email='+data.email+"&code="+data.code, {
        method: 'Get',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(response => {
        console.log(response)
        if (response.status !== 200)
          document.getElementById('display').innerHTML = response.error;
        else
        document.getElementById('display').innerHTML = response.message;
        
          document.getElementById('display').style.display = 'block';
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
    <div className="card mx-auto mt-5" style={{ maxWidth: '450px' }}>
      <div className="card-body p-5">
        <h2 className="card-title text-center mb-4">
          Email Verification
        </h2>

        <div className="alert alert-primary" role="alert" id="display" style={{ display: 'none' }}></div>
       
        <form onSubmit={(e) => e.preventDefault()}>
        
          {/* Fields */}
            <div className="row mb-3">
              <label className="form-label">Email Address</label>
              <input type="text" className="form-control" onChange={(e) => setEmail(e.target.value)} />
            </div>
            <div className="row mb-3">
              <label className="form-label">Verification Code</label>
              <input type="text" className="form-control" onChange={(e) => setCode(e.target.value)} />
            </div>

          {/* Buttons */}
          <div className="row mt-3">
            <div className="col mb-3">
            <button className="btn btn-success w-100" onClick={handleVerification}>Verify</button>
            </div>
          </div>

        </form>
      </div>
    </div>
   
  );
};

export default Verification;