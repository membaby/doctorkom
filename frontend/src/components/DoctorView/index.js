import React, { useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import elementsGenerator from "./DashBoardComponents/DashBoardElements/ElementsGenerator";
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
            <div className="container py-4 py-xl-5">
                <h3>Doctor Dashboard</h3>
                {elementsGenerator()}
            </div>
        </div>
    );
}
