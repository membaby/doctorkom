import './styles.css'
import React, { useState, useEffect } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';

import Dropdown from 'react-bootstrap/Dropdown';
const Navbar = () => {

  var NavbarItems = [
    { title: 'Home', url: '/' },
    { title: 'Search', url: '/'},
    { title: 'Contact us', url: '/' },
    { title: 'About us', url: '/' },
    { title: 'Login', url: '/login' },
  ];
  const [activeIndex, setActiveIndex] = useState(null);

  const handleClick = (index) => {
    setActiveIndex(index);
  };
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

  
    const [isDropdownOpen, setDropdownOpen] = useState(false);

    const toggleDropdown = () => {
      setDropdownOpen(!isDropdownOpen);
    };
    return(
	<>

 
<nav class="navbar navbar-expand-lg navbar-dark">

									<a href="/">
										<div class="logo">
											<img src="/images/logo2.png" alt="logo" />
										</div>
									</a>
							
 	<div class="col-5"></div>


 <div className="col-6 d-flex nav-link text-white riMar  ">
  {NavbarItems.map((item, index) => (
    <div className="nav-item  m-auto" >
      <a className="nav-link" href={item.url} style={{ fontSize: '21px' }}>{item.title}</a>
    </div>
  ))}
 <div className="nav-item  m-auto" >
    <Dropdown>
      <Dropdown.Toggle  as={CustomToggle} variant="success" id="dropdown-basic"  >
      Register
      </Dropdown.Toggle>
      <Dropdown.Menu>
        <Dropdown.Item href="/RegisterP">Patient registration</Dropdown.Item>
        <Dropdown.Item href="/RegisterD">Doctor registration</Dropdown.Item>
      </Dropdown.Menu>
    </Dropdown>
    </div>
    </div> 





 </nav> 

		</>
    );
};

export default Navbar;







//  <div class="collapse navbar-collapse" id="navbarSupportedContent">
//       <ul className="navbar-nav ms-auto">
//         {NavbarItems.map((item, index) => (
//      <li className="nav-item">
//       <a className="nav-link active" href={item.url}>{item.title}</a>
//       </li>
//   ))} 
        
//        </ul>
//     </div> 