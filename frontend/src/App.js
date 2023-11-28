import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

import Navbar from './components/navbar';
import Register from './components/register';
import Homepage from './components/homepage';
// import RegisterD from './components/registerd';

function App() {
  return (
    <Router>
      <div class="fixed-top">
        <Navbar />
      </div>
      <div class="empty_block d-block w-100"></div>

      <div class="mb-5">
        
        <Routes>
          <Route path='/' element={ <Homepage/> } />
          <Route path='/register/patient' element={ <Register userType="patient" /> } />
          <Route path='/register/doctor' element={ <Register  userType="doctor" /> } />
          <Route path='/register/admin' element={ <Register   userType="admin" /> } />
          <Route path='/register/clinic' element={ <Register  userType="clinic" /> } />
        </Routes>

      </div>
    </Router>
  )
}

export default App;

