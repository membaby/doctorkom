
// export default App;
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

// TODO: Optimization using Lazy React.

import Navbar from './components/navbar';
// import Footer from './components/footer';

import Register from './components/register';
import Homepage from './components/homepage';


function App() {
  return true ? (
    <Router>
      <div class="fixed-top">
        <Navbar />
      </div>
      <div class="empty_block d-block w-100"></div>

      <div class="mb-5">
        <Routes>
          <Route path='/' element={ <Homepage/> } />
          
          <Route path='/register' element={ <Register /> } />
        </Routes>
      </div>
      
      <div class="fixed-bottom">
        {/* <Footer /> */}
      </div>
    </Router>
     ):(<></>)

}

export default App;

