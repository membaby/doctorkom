import logo from './logo.svg';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

import SystemAdminView from './components/SystemAdminView';

function App() {
  return (
    <Router>
      <div class="empty_block d-block w-100"></div>

      <div class="mb-5">
        
        <Routes>
          <Route path='/' element={ <SystemAdminView /> } />
        </Routes>

      </div>
    </Router>
  );
}

export default App;
