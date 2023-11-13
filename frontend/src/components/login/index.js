
import './styles.css'
import React, { useState } from 'react';
const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
  
    const handleUsernameChange = (event) => {
      setUsername(event.target.value);
    };
  
    const handlePasswordChange = (event) => {
      setPassword(event.target.value);
    };
  
    const handleLogin = () => {
      // Handle login logic here
      console.log('Username:', username);
      console.log('Password:', password);
    };

    const logAuthen = async (query='',password='') => {
      const response = await fetch(''+query+'?'); ////
      const jsonData = await response.json();
      let flag=false
      jsonData.forEach(user => {
                  if (user.username === query && user.password === password) {
                      flag=true
                  }
              });
      if(flag===true)
          return true
      else
         return false
  };

  
	
	return (
		<>


  
    <div className="card mx-auto mt-5" style={{ width: '400px', height: '400px' }}>
      <div className="card-body d-flex flex-column align-items-center justify-content-center">
        <h2 className="card-title text-center mb-4">Login</h2>
        <form className="w-100">
          <div className="mb-3">
            <label htmlFor="username" className="form-label">
              Username
            </label>
            <input
              type="text"
              id="username"
              className="form-control"
              value={username}
              onChange={handleUsernameChange}
            />
          </div>
          <div className="mb-3">
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
          <div className="d-grid d-flex justify-content-center">
            <button className="btn  btn-success" onClick={ logAuthen(username, password)}>
              Login
            </button>
          </div>
        </form>
      </div>
    </div>

		</>
  	);
};

export default Login;