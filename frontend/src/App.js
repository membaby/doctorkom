import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

import AdminHomePage from './components/SystemAdminView';

function App() {
  return (
    <Router>
      <div>
        
        <Routes>
          <Route path='/dashboard/admin' element={ <AdminHomePage/> } />
        </Routes>

      </div>
    </Router>
  )
}

export default App;