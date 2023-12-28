import React, { useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useLocation } from 'react-router-dom';
import secureLocalStorage from "react-secure-storage";

export default function Reservation() {

    // useEffect(() => {
    //     if (!secureLocalStorage.getItem('id')) {
    //         window.location.href = '/login';
    //     }
    // })

    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const appointmentDetails = {
        doctorName: queryParams.get('doctorName'),
        clinicName: queryParams.get('clinicName'),
        doctorId: queryParams.get('doctorId'),
        clinicId: queryParams.get('clinicId'),
        // patientId: secureLocalStorage.getItem('id'),
        patientId: 1195,
        date: queryParams.get('date'),
        start: queryParams.get('start'),
        end: queryParams.get('end')
    }

    const createAppointment = () => {
        const patient_name = document.getElementById('patient_name').value;
        const patient_mobile = document.getElementById('patient_mobile').value;
        const patient_email = document.getElementById('patient_email').value;

        if (!patient_name || !patient_mobile || !patient_email) {
            showError('Please fill all the fields');
            return;
        }

        showError('Creating appointment...');

        const data = {
            timeSlot: {
                doctor: {id: appointmentDetails.doctorId},
                clinic: {id: appointmentDetails.clinicId},
                date: appointmentDetails.date,
                startTime: appointmentDetails.start,
                endTime: appointmentDetails.end,
                reserved: false
            },
            patient: {id: appointmentDetails.patientId}
        }
        console.log(data);

        fetch('http://localhost:8080/appointments/bookAppointment', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(response => {
            if (response.success) {
                showError('Appointment created successfully');
                setTimeout(() => {
                    window.location.href = '/appointments';
                }, 1000);
            } else {
                console.log(response.msg);
                showError(response.msg);
            }
        })
        .catch((error) => {
            showError('Internal Server Error occured. Please try again later.')
        }
        );

        // window.location.href = '/appointments';
    }

    const showError = (message) => {
        const display = document.getElementById('display');
        if (message) {
            display.innerHTML = message;
            display.style.display = 'block';
        } else {
            display.innerHTML = '';
            display.style.display = 'none';
        }
    }


    return (
        <div className="grayBackground">
        <div className="container vh-100 d-flex align-items-center justify-content-center">
          <div className="panelCard" style={{'width': '800px'}}>
            <div className="card-body d-flex flex-column align-items-center justify-content-center">
                <img src="/images/appointment.png" width="100px" />
                <h2 className="card-title text-center mb-4 mt-3">New Appointment</h2>
                <div className="alert alert-primary w-100 text-center" id="display" style={{'display': 'none'}}></div>

                <hr/>
                <div className="row w-100">
                    <div className="col">
                        <div className="text-start w-100">
                            <div className="h6 text-muted">Doctor Name</div> <div className="h5">Dr. {appointmentDetails.doctorName}</div>
                        </div>
                    </div>
                    <div className="col">
                        <div className="w-100 text-center ">
                            <div className="h6 text-muted">Date & Time</div> <div className="h5">{appointmentDetails.date} {appointmentDetails.start.split(':').slice(0, 2).join(':')}</div>
                        </div>
                    </div>
                    <div className="col">
                        <div className="text-end w-100">
                            <div className="h6 text-muted">Clinic Name</div> <div className="h5">{appointmentDetails.clinicName}</div>
                        </div>
                    </div>
                </div>
                <hr/>

              <div className="alert alert-primary" role="alert" id="display" style={{ display: 'none' }}></div>

              <form className="w-100" onSubmit={(e) => e.preventDefault()}>

                <div className="mb-3">
                  <label className="form-label">Patient Name</label>
                  <input type="text" className="form-control" id="patient_name" />
                </div>
                <div className="mb-4">
                    <div className="row">
                        <div className="col">
                            <label className="form-label">Mobile Number</label>
                            <input type="text" className="form-control" id="patient_mobile" />
                        </div>
                        <div className="col">
                            <label className="form-label">Email Address</label>
                            <input type="email" className="form-control" id="patient_email" />
                        </div>
                    </div>
                </div>
                
                <button className="custom-button custom-button-primary w-100" onClick={createAppointment} >Confirm Appointment</button>
                
              </form>
            </div>
          </div>
        </div>
      </div>
    )
}