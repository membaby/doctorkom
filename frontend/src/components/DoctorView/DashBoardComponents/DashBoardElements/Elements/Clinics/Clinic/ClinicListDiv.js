import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ClinicListDiv({ clinic }) {
    const { name, address, mobilePhone,landlinePhone } = clinic;

    return (
        <a
            className="list-group-item list-group-item-action d-flex gap-3 py-3"
            aria-current="true"
            style={{
                border: '1px solid rgb(36, 44, 60)',
                borderRadius: '0.25rem',
                backgroundColor: 'rgb(175, 238, 238)',
                marginBottom: '5px',
                marginTop: '5px'
            }}
        >
            <div className="w-100">
                <div className="d-flex justify-content-between">
                    <h6 className="mb-0">{name}</h6>
                    <p className="mb-0">{address}</p>
                </div>
                <div className="d-flex justify-content-between">
                    <div className="mb-0">mobilePhone: {mobilePhone}</div>
                    <div className="mb-0">landlinePhone: {landlinePhone}</div>
                </div>
            </div>
        </a>
    );
}