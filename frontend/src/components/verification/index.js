import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';

const Verification = () => {
  let location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const emailAddress = searchParams.get('email'); 
  const [email, setEmail] = useState(emailAddress);
  const [code, setCode] = useState(null);

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

  
    fetch('http://localhost:8080/verify?email='+data.email+"&code="+data.code, {method: 'GET'})
    .then(response => response.text())
    .then(response => {
        if (response === "success") {
          document.getElementById('display').innerHTML = 'Email verified successfully. <a href="/login">Click here</a> to login.';
        } else if (response === "wrong code") {
          document.getElementById('display').innerHTML = 'Wrong code entered. Please try again.';
        } else if (response === "email not registered") {
          document.getElementById('display').innerHTML = 'Email not registered. Please register first.';
        } else if (response === "already verified") {
          document.getElementById('display').innerHTML = 'Email already verified. <a href="/login">Click here</a> to login.';
        }
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
              <input type="text" className="form-control" onChange={(e) => setEmail(e.target.value)} value={emailAddress} />
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