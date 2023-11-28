import React from "react"
import './styles.css'

import 'bootstrap/dist/css/bootstrap.min.css';

export default function Navbar() {

  var NavbarItems = [
    { title: 'Home', url: '/system-admin' },
    { title: 'Add Clinic', url: '/systemAdmin/add-clinic'},
    { title: 'Remove Clinic', url: '/system-admin/remove-clinic' },
    { title: 'Logout', url: '/' },
  ];
  
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
            </div> 

        </nav> 
    </>
    );
};

