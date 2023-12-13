import './styles.css'
import React, { useState, useEffect } from 'react';
import { useGoogleLogin } from '@react-oauth/google';
import axios from 'axios';
import Cookies from 'universal-cookie';
import hashString from '../../functions/hashString';

const Login = () => {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const cookies = new Cookies();

  const handleLogin = (googleid = undefined) => {
    const data = {}
    if (googleid) {
      data.username = googleid;
      data.password = "mchbomNZPYvmxbv0e3yNAy";
    } else {
      data.username = username;
      data.password = hashString(password);
    }

    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(response => {
        if (response.success) {
          localStorage.setItem('role', response.role);
          cookies.set('role', response.role, { path: '/' });
          if (response.role === 'PATIENT') {
            cookies.set('id', response.patient.id, { path: '/' });
            cookies.set('username', response.patient.systemUser.account.username, { path: '/' });
            window.location.href = '/search';
          } else if (response.role === "SYSTEM_ADMIN") {
            cookies.set('id', response.systemAdmin.id, { path: '/' });
            window.location.href = '/dashboard/admin';
          } else if (response.role === "CLINIC_ADMIN") {
            cookies.set('id', response.clinic.id, { path: '/' });
            cookies.set('username', response.clinic.admin.account.username, { path: '/' });
            window.location.href = '/dashboard/clinic';
          } else if (response.role === "DOCTOR") {
            cookies.set('id', response.doctor.id, { path: '/' });
            cookies.set('username', response.doctor.systemUser.account.username, { path: '/' });
            window.location.href = '/dashboard/doctor';
          } else {
            window.location.href = '/';
          }
        } else {
          if (googleid) {
            showError("Google authenticaiton failed. Please register first. (<a href='/register/patient'>Click Here!</a>)");
          } else {
            showError("Invalid username or password OR account not activated.");
          }
        }
    })
    .catch((error) => {
        showError('Error occured. Please try again later:' + error)
    });
  }

  const forgotPassword = () => {
    const data = {
      username: username,
    }

    if (!username) {
      showError('Please enter your username');
      return;
    }

    fetch('http://localhost:8080/recover_password', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
    .then(response => response.text())
    .then(response => {
      showError("(demo) An email has been sent to your email address with a link to reset your password.");
    })
    .catch((error) => {
        showError('Error occured. Please try again later.')
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

  const [user, setUser] = useState({});

  const googleLogin = useGoogleLogin({
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
        handleLogin(res.data.email);
      }).catch((err) => console.log(err));
    }
  }, [user]); // Depend on user object

	return (
		<>
    <div className="container">
      <div className="card mx-auto mt-5" style={{ width: '400px', height: '500px' }}>
        <div className="card-body d-flex flex-column align-items-center justify-content-center">
          <h2 className="card-title text-center mb-4">Login</h2>

          <div className="alert alert-primary" role="alert" id="display" style={{ display: 'none' }}></div>

          <form className="w-100" onSubmit={(e) => e.preventDefault()}>

            <div className="mb-3">
              <label className="form-label">Username</label>
              <input type="text" className="form-control" onChange={(e) => setUsername(e.target.value)} />
            </div>
            <div className="mb-3">
              <label className="form-label">Password</label>
              <input type="password" className="form-control" onChange={(e) => setPassword(e.target.value)} />
            </div>

            <div className="d-grid d-flex justify-content-center">
              <button className="btn btn-success w-100 mx-1" onClick={()=>handleLogin()}>Login</button>
              <button className="btn btn-danger w-100 mx-1" onClick={()=>{googleLogin()}} >Login with Google</button>
            </div>

            <div className="mt-3 clickable text-primary" onClick={forgotPassword}>Forgot Password?</div>
          </form>
        </div>
      </div>
    </div>
		</>
  	);
};

export default Login;