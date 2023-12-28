import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import elementsGenerator from "./DashBoardComponents/DashBoardElements/ElementsGenerator";

export default function DoctorHomePage() {
    return (
        <div>
            <div className="container py-4 py-xl-5">
                <h3>Doctor Dashboard</h3>
                {elementsGenerator()}
            </div>
        </div>
    );
}
