import './styles.css'
import React, { useState, useEffect } from 'react';
import { useGoogleLogin } from '@react-oauth/google';
import axios from 'axios';


const Login = () => {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const handleLogin = () => {
    const data = {
      username: username,
      password: password
    };
  
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
            // window.location.href = '/search';
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
        setUsername(res.data.id);
        setPassword("mchbomNZPYvmxbv0e3yNAy");
        handleLogin();
      }).catch((err) => console.log(err));
    }
  }, [user]); // Depend on user object

	return (
		<>
      <div className="card mx-auto mt-5" style={{ width: '400px', height: '400px' }}>
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
              <input type="text" className="form-control" onChange={(e) => setPassword(e.target.value)} />
            </div>

            <div className="d-grid d-flex justify-content-center">
              <button className="btn btn-success w-100" onClick={handleLogin}>Login</button>
              <button className="btn btn-danger w-100" onClick={()=>{googleLogin()}} >Login with Google</button>
            </div>
          </form>
        </div>
      </div>
		</>
  	);
};

export default Login;