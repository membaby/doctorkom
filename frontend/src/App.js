import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

import Navbar from './components/navbar';
import Register from './components/register';
import Verification from './components/verification';
import Homepage from './components/homepage';
import Login from './components/login';
import AdminHomePage from './components/SystemAdminView';
import ClinicHomePage from './components/ClinicView';
import DoctorHomePage from './components/DoctorView';
import Search from './components/Search';
import UserProfilePage from './components/UserProfile';
import DoctorDetails from './components/DoctorDetails';
import Reservation from './components/Reservation';
import About from './components/About';
import Footer from './components/Footer';

function App() {
  return (
    <Router>
      <div class="fixed-top">
        <Navbar />
      </div>
      <div className="empty_block"></div>

      <div class="MainContainer">
        
        <Routes>
          <Route path='/' element={ <Homepage/> } />
          <Route path='/register/patient' element={ <Register userType="patient" /> } />
          <Route path='/register/doctor' element={ <Register  userType="doctor" /> } />
          <Route path='/register/admin' element={ <Register   userType="admin" /> } />
          <Route path='/register/clinic' element={ <Register  userType="clinic" /> } />
          <Route path='/login' element={ <Login /> } />
          <Route path='/verification' element={ <Verification /> } />
          <Route path='/dashboard/admin' element={ <AdminHomePage /> } />
          <Route path='/dashboard/clinic' element={ <ClinicHomePage /> } />
          <Route path='/dashboard/doctor' element={ <DoctorHomePage /> } />
          <Route path='/search' element={ <Search /> } />
          <Route path='/logout' element={ <Homepage /> } />
          <Route path='/profile' element={ <UserProfilePage /> } />
          <Route path='/doctor/:username' element={ <DoctorDetails /> } />
          <Route path='/reserve' element={ <Reservation /> } />
          <Route path='/about' element={ <About /> } />
        </Routes>

      </div>
      <Footer />
    </Router>

)
}

export default App;

