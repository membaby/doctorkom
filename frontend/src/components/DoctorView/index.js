import React, { useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import secureLocalStorage from "react-secure-storage";


export default function DoctorHomePage() {

    useEffect(() => {
        const role = secureLocalStorage.getItem('role');
        const id = secureLocalStorage.getItem('id');
        const username = secureLocalStorage.getItem('username');
        
        if (!role || !id || !username || role !== 'DOCTOR') {
          window.location.href = '/';
        }
      }, [])
    

    return (
        <div>
            <div class="container py-4 py-xl-5">
                <h3>Doctor Dashboard</h3>
                <hr/>

                Page under construction.

            </div>
        </div>
    )
}