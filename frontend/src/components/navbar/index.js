import './styles.css'
import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Dropdown from 'react-bootstrap/Dropdown';
import Cookies from 'js-cookie';
import { useLocation } from 'react-router-dom';


const Navbar = () => {

  const location = useLocation();
  const currentRoute = location.pathname;

  const [navbar, setNavbar] = useState([
    { title: 'Home', url: '/' },
    { title: 'Search', url: '/search'},
    { title: 'About', url: '/about' },
  ]);
  const [showRegisterButton, setShowRegisterButton] = useState(false);

  useEffect(() => {
    let updatedNavbar = [...navbar];
    let role = Cookies.get('role');
    let username = Cookies.get('username');
    if (!role || !username) {
      updatedNavbar.push({ title: 'Login', url: '/login' });
      setShowRegisterButton(true);
    } else if (role === "PATIENT") {
      updatedNavbar.push({ title: 'Profile', url: '/profile' });
      updatedNavbar.push({ title: 'My Appointments', url: '/appointments' });
      updatedNavbar.push({ title: 'Logout', url: '/logout' });
    } else if (role === "DOCTOR") {
      updatedNavbar.push({ title: 'Profile', url: '/profile' });
      updatedNavbar.push({ title: 'Dashboard', url: '/dashboard/doctor' });
      updatedNavbar.push({ title: 'Logout', url: '/logout' });
    } else if (role === "CLINIC_ADMIN") {
      updatedNavbar.push({ title: 'Dashboard', url: '/dashboard/clinic' });
      updatedNavbar.push({ title: 'Logout', url: '/logout' });
    } else if (role === "SYSTEM_ADMIN") {
      updatedNavbar.push({ title: 'Dashboard', url: '/dashboard/admin' });
      updatedNavbar.push({ title: 'Logout', url: '/logout' });
    } else {
      updatedNavbar.push({ title: 'Login', url: '/login' });
      setShowRegisterButton(true);
    }
    setNavbar(updatedNavbar);
  }, []);

  const CustomToggle = React.forwardRef(({ children, onClick }, ref) => (
    <div
      ref={ref}
      onClick={(e) => {
        e.preventDefault();
        onClick(e);
      }}
      style={{ color: 'white', textDecoration: 'none' }}
    >
      {children}
    </div>
  ));

  return(
	<>
    <nav className="navbar navbar-expand-lg navbar-dark">
      <a href="/">
        <div className="logo">
          <img src="/images/logo2.png" alt="logo" />
        </div>
      </a>			
      <div className="col"></div>
      <div className="col-auto d-flex nav-link text-white riMar">
        {navbar.map((item, index) => (
          <div className={`nav-item  m-auto mx-4 ${item.url === currentRoute ? "nav-active" : ""}`} >
            {item.title === "Profile" ? (
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                </svg>
              ) : item.title === "Search" ? (
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                </svg>
              ) : item.title === "Home" ? (
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
                <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z"/>
              </svg>) : (<></>)}
              <a className="nav-link" href={item.url} style={{ fontSize: '21px' }}>{item.title}</a>
          </div>
        ))}
        {showRegisterButton ? (
          <div className="nav-item  m-auto mx-4" >
            <Dropdown>
              <Dropdown.Toggle  as={CustomToggle} variant="success" id="dropdown-basic"  >
              <div className="register-button">Register</div>
              </Dropdown.Toggle>
              <Dropdown.Menu>
                <Dropdown.Item href="/register/patient">Patient registration</Dropdown.Item>
                <Dropdown.Item href="/register/doctor">Doctor registration</Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>
          </div>
        ) : (<></>)}
      </div> 
    </nav> 
	</>
  );
};

export default Navbar;