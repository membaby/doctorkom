import './styles.css'
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Dropdown from 'react-bootstrap/Dropdown';

const Navbar = () => {

  var NavbarItems = [
    { title: 'Home', url: '/' },
    { title: 'Search', url: '/search'},
    { title: 'About', url: '/about' },
    { title: 'Login', url: '/login' },
  ];

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
        {NavbarItems.map((item, index) => (
          <div className="nav-item  m-auto mx-4" >
            <a className="nav-link" href={item.url} style={{ fontSize: '21px' }}>{item.title}</a>
          </div>
        ))}
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
      </div> 
    </nav> 
	</>
  );
};

export default Navbar;