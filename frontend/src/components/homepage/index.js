import React from 'react';
import './styles.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import { useLocation } from 'react-router-dom';
import Cookies from 'js-cookie';

const Homepage = () => {

  const location = useLocation();
  const currentRoute = location.pathname;
  if (currentRoute === "/logout") {
    Cookies.set('role', '');
    Cookies.set('username', '');
    Cookies.set('id', '');
  }

  return (
    <>
      <div className="homepage-container">
        <h1 className="well-being-text">Putting Your Well-being First</h1>
        <a href="/search">
          <button type="button" className="homepage-button">Find Doctors</button>
        </a>
        <a href="/register/patient">
          <button type="button" className="homepage-button">Join Platform</button>
        </a>
      </div>
    </>
  );
};

export default Homepage;
