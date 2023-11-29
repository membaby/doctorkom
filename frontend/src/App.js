import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

import AdminHomePage from './components/SystemAdminView';
import ClinicHomePage from './components/ClinicView';
import DoctorHomePage from './components/DoctorView';

function App() {
  return (
    <Router>
      <div>
        
        <Routes>
          <Route path='/dashboard/admin' element={ <AdminHomePage/> } />
          <Route path='/dashboard/clinic' element={ <ClinicHomePage/> } />
          <Route path='/dashboard/doctor' element={ <DoctorHomePage/> } />
        </Routes>

      </div>
    </Router>
  )
}

export default App;