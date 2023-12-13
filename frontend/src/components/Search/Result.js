import React from "react";
import './styles.css';

export default function Result() {
    return (<>

        <div className="result">
            <div className="row">
                <div className="col-auto">
                    <img src="/images/avatar/default-doctor-male.png" alt="Doctor" className="avatar" width="150px" />
                </div>
                <div className="col-auto">
                    <div className="doctor-name">Dr. Mahmoud Tarek</div>
                </div>
            </div>
        </div>

    </>)
}