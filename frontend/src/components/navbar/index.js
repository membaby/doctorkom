import './styles.css'
import React, { useState, useEffect } from 'react';
const Navbar = () => {

  var NavbarItems = [
    { title: 'Home', url: '/' },
    { title: 'Search', url: '/'},
    { title: 'Contact us', url: '/' },
    { title: 'About us', url: '/' },
    { title: 'Login', url: '/login' },
    { title: 'Register', url: '/Register' }
  ];
  const [activeIndex, setActiveIndex] = useState(null);

  const handleClick = (index) => {
    setActiveIndex(index);
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

 <div className="col-6 d-flex nav-link text-white   ">
  {NavbarItems.map((item, index) => (
    <div className="nav-item  m-auto" >
      <a className="nav-link" href={item.url}>{item.title}</a>
    </div>
  ))}
</div> 
    






 </nav> 

		</>
    );
};

export default Navbar;





{/* <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav ms-auto">
        {NavbarItems.map((item, index) => (
     <li className="nav-item">
      <a className="nav-link active" href={item.url}>{item.title}</a>
      </li>
  ))} */}
        
      {/* </ul>
    </div>  */}