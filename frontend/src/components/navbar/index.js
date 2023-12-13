import './styles.css'
import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Dropdown from 'react-bootstrap/Dropdown';
import Cookies from 'js-cookie';

const Navbar = () => {

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
    <a
      href=""
      ref={ref}
      onClick={(e) => {
        e.preventDefault();
        onClick(e);
      }}
      style={{ color: 'white', textDecoration: 'none' }}
    >
      {children}
    </a>
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
          <div className="nav-item  m-auto mx-4" >
            <a className="nav-link" href={item.url} style={{ fontSize: '21px' }}>{item.title}</a>
          </div>
        ))}
        {showRegisterButton ? (
          <div className="nav-item  m-auto mx-4" >
            <Dropdown>
              <Dropdown.Toggle  as={CustomToggle} variant="success" id="dropdown-basic"  >
              Register
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