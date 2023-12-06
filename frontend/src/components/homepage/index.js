import React from 'react';
import './styles.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';

const Homepage = () => {
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
