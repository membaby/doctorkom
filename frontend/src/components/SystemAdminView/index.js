import React, { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import hashString from '../../functions/hashString';
import secureLocalStorage from "react-secure-storage";

export default function AdminHomePage() {

    const [insights, setInsights] = useState(null);

    useEffect(() => {
        fetch('http://localhost:8080/admin/adminInsights', {method: 'GET'})
        .then(response => response.json())
        .then(response => {
            setInsights(response)
        });
    }, [])

    useEffect(() => {
        const role = secureLocalStorage.getItem('role');
        const id = secureLocalStorage.getItem('id');
        const username = secureLocalStorage.getItem('username');
        
        if (!role || !id || !username || role !== 'SYSTEM_ADMIN') {
          window.location.href = '/';
        }
    }, [])

    const createClinic = () => {
        const name = document.getElementById('clinicName').value;
        const email = document.getElementById('clinicEmail').value;
        const address = document.getElementById('clinicAddress').value;
        const landline = document.getElementById('clinicLandline').value;
        const phone = document.getElementById('clinicPhone').value;
        const username = document.getElementById('clinicUsername').value;
        const password = document.getElementById('clinicPassword').value;

        const data = {
            clinic: {
                name: name,
                address: address,
                email: email,
                mobilePhone: phone,
                landlinePhone: landline,
                admin: {}
            },
            account: {
                email: email,
                username: username,
                password: hashString(password),
                role: "CLINIC_ADMIN",
            }
        };

        if (!name || !email || !address || !landline || !phone) {
            showError('Please fill all the fields');
            return;
        }
        showError("Creating clinic.. Please wait!");
      
        fetch('http://localhost:8080/admin/newclinic', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data),
        })
        .then(response => response.text())
        .then(response => {
            if (response.success) {
                showError("Clinic created successfully!");
            } else {
                showError(response.msg);
            }
        })
        .catch((error) => {
            showError('Internal Server Error occured. Please try again later.')
        }
        );
    }

    const deleteClinic = () => {
        const id = document.getElementById('clinicId').value;

        if (!id) {
            showError('Please fill all the fields');
            return;
        }
    
        showError("Deleting clinic.. Please wait!");
        fetch('http://localhost:8080/removeClinic', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: id
            })
            .then(response => response.text())
            .then(response => {
                if (response.success) {
                    showError("Clinic deleted successfully!");
                } else {
                    showError(response.msg);
                }
            })
            .catch((error) => {
                showError('Internal Server Error occured. Please try again later.')
            }
        );
    }

    const sendNotification = () => {
        const data = {
            "email": document.getElementById('userEmail-notification').value,
            "message": document.getElementById('userMessage').value
        }
        fetch('http://localhost:8080/admin/sendAdminMessage', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data),
        })
        .then(response => response.text())
        .then(response => {
            showError(response);
            })
            .catch((error) => {
                showError('Internal Server Error occured. Please try again later.')
            }
        );
    }

    const inviteAdmin = () => {
        const emailAddress = document.getElementById('AdminEmail').value;
        const password = document.getElementById('AdminPassword').value;

        if (!emailAddress || !password) {
            showError('Please fill all the fields');
            return;
        }

        const data = {
            email: emailAddress,
            username: emailAddress.split('@')[0],
            password: hashString(password),
            role: "SYSTEM_ADMIN"
        }
    
        showError("Creating account.. Please wait!");
        fetch('http://localhost:8080/admin/createAdmin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
            })
            .then(response => response.text())
            .then(response => {
                if (response.success) {
                    showError("Admin invited successfully!");
                } else {
                    showError(response.msg);
                }
            })
            .catch((error) => {
                showError('Internal Server Error occured. Please try again later.')
            }
        );
    }

    const deactiveUser = () => {
        const username = document.getElementById('delete-username').value;
        if (!username) {
            showError('Please fill all the fields');
            return;
        }

        showError("Deleting account.. Please wait!");
        fetch('http://localhost:8080/account/'+username, {
            method: 'DELETE'
        }).then(response => {
            if (response.ok) {
                showError("Account deleted successfully!");
            } else {
                showError("Account deletion failed!");
            }
        }).catch((error) => {
            showError('Internal Server Error occured. Please try again later.')
        });
    }

    
      const showError = (msg) => {
        if (!msg) {
          const error = document.getElementById('display');
          error.style.display = 'none';
          return;
        }
        const error = document.getElementById('display');
        error.innerHTML = msg;
        error.style.display = 'block';
    }

    const generateUsername = (event) => {
        const username = document.getElementById('clinicUsername');
        username.value = event.target.value.replace(/\s/g, '').replace(/[^a-zA-Z0-9]/g, '').toLowerCase();
    }

    return (
        <div>
            <div class="container py-4 py-xl-5">
                <h3>Admin Dashboard</h3>
                <hr/>

                <div className="alert alert-primary" role="alert" id="display" style={{ display: 'none' }}></div>

                <div class="row gy-4 row-cols-2 row-cols-md-4">
                    <div class="col">
                        <div class="text-center d-flex flex-column justify-content-center align-items-center py-3">
                            <div class="bs-icon-xl bs-icon-circle bs-icon-primary d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block mb-2 bs-icon lg"><svg class="bi bi-person" xmlns="http://www.w3.org/2000/svg" width="5em" height="5em" fill="currentColor" viewBox="0 0 16 16">
                                    <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"></path>
                                </svg></div>
                            <div class="px-3">
                                <h2 class="fw-bold mb-0">{insights ? (insights.totalAccounts) : (<h6>Loading...</h6>)}</h2>
                                <p class="mb-0">Total System Users</p>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="text-center d-flex flex-column justify-content-center align-items-center py-3">
                            <div class="bs-icon-xl bs-icon-circle bs-icon-primary d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block mb-2 bs-icon lg"><svg class="bi bi-person-up" xmlns="http://www.w3.org/2000/svg" width="5em" height="5em" fill="currentColor" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.354-5.854 1.5 1.5a.5.5 0 0 1-.708.708L13 11.707V14.5a.5.5 0 0 1-1 0v-2.793l-.646.647a.5.5 0 0 1-.708-.708l1.5-1.5a.5.5 0 0 1 .708 0ZM11 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Z"></path>
                                    <path d="M8.256 14a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1h5.256Z"></path>
                                </svg></div>
                            <div class="px-3">
                                <h2 class="fw-bold mb-0">{insights ? (insights.totalDoctors) : (<h6>Loading...</h6>)}</h2>
                                <p class="mb-0">Active Doctors</p>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="text-center d-flex flex-column justify-content-center align-items-center py-3">
                            <div class="bs-icon-xl bs-icon-circle bs-icon-primary d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block mb-2 bs-icon lg">
                            <svg xmlns="http://www.w3.org/2000/svg" width="5em" height="5em" fill="currentColor" class="bi bi-building" viewBox="0 0 16 16">
                                <path d="M4 2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1ZM4 5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1ZM7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1ZM4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Z"/>
                                <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V1Zm11 0H3v14h3v-2.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5V15h3V1Z"/>
                            </svg>
                            </div>
                            <div class="px-3">
                                <h2 class="fw-bold mb-0">{insights ? (insights.totalClinics) : (<h6>Loading...</h6>)}</h2>
                                <p class="mb-0">Total Clinics</p>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="text-center d-flex flex-column justify-content-center align-items-center py-3">
                            <div class="bs-icon-xl bs-icon-circle bs-icon-primary d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block mb-2 bs-icon lg"><svg class="bi bi-boxes" xmlns="http://www.w3.org/2000/svg" width="5em" height="5em" fill="currentColor" viewBox="0 0 16 16">
                                    <path d="M7.752.066a.5.5 0 0 1 .496 0l3.75 2.143a.5.5 0 0 1 .252.434v3.995l3.498 2A.5.5 0 0 1 16 9.07v4.286a.5.5 0 0 1-.252.434l-3.75 2.143a.5.5 0 0 1-.496 0l-3.502-2-3.502 2.001a.5.5 0 0 1-.496 0l-3.75-2.143A.5.5 0 0 1 0 13.357V9.071a.5.5 0 0 1 .252-.434L3.75 6.638V2.643a.5.5 0 0 1 .252-.434L7.752.066ZM4.25 7.504 1.508 9.071l2.742 1.567 2.742-1.567L4.25 7.504ZM7.5 9.933l-2.75 1.571v3.134l2.75-1.571V9.933Zm1 3.134 2.75 1.571v-3.134L8.5 9.933v3.134Zm.508-3.996 2.742 1.567 2.742-1.567-2.742-1.567-2.742 1.567Zm2.242-2.433V3.504L8.5 5.076V8.21l2.75-1.572ZM7.5 8.21V5.076L4.75 3.504v3.134L7.5 8.21ZM5.258 2.643 8 4.21l2.742-1.567L8 1.076 5.258 2.643ZM15 9.933l-2.75 1.571v3.134L15 13.067V9.933ZM3.75 14.638v-3.134L1 9.933v3.134l2.75 1.571Z"></path>
                                </svg></div>
                            <div class="px-3">
                                <h2 class="fw-bold mb-0">{insights ? (insights.totalAppointments) : (<h6>Loading...</h6>)}</h2>
                                <p class="mb-0">Active Appointments</p>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col-6">
                        <h4 class="text-center">User Management</h4>
                        <div class="card p-3">
                            <h6>Send notification to a user</h6>
                                <input type="email" class="form-control" id="userEmail-notification" placeholder="User Email Address"/>
                                <textarea class="form-control mt-2" id="userMessage" rows="4" placeholder="Notification Message"></textarea>
                                <button class="btn btn-primary mt-2 " onClick={sendNotification}>Send</button>
                        </div>
                        <div class="card p-3 mt-3">
                            <h6>Invite New Admin</h6>
                            <input type="email" class="form-control" placeholder="User Email Address" id="AdminEmail" />
                            <input type="password" class="form-control mt-1" placeholder="Password" id="AdminPassword"/>
                            <button class="btn btn-warning mt-2 w-100" onClick={inviteAdmin}>Invite</button>
                        </div>
                        <div class="card p-3 mt-3">
                            <h6>Delete User Account</h6>
                            <div class="row">
                                <div class="col-9">
                                    <input type="username" class="form-control" placeholder="Username" id="delete-username"/>
                                </div>
                                <div class="col">
                                    <button class="btn btn-danger  w-100" onClick={deactiveUser}>Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <h4 class="text-center">Clinic Management</h4>
                        <div class="card p-3">
                            <h6 className="m-auto">Create New Clinic</h6>
                                <div className="text-muted">Clinic Details</div>
                                <input type="text" class="form-control mb-2" id="clinicName" placeholder="Name" onChange={generateUsername}/>
                                <input type="text" class="form-control mb-2" id="clinicAddress" placeholder="Full Address"/>
                                <input type="text" class="form-control mb-2" id="clinicLandline" placeholder="Landline"/>
                                <input type="text" class="form-control mb-2" id="clinicPhone" placeholder="Phone Number"/>

                                <div className="text-muted">Clinic Admin Details</div>
                                <input type="text" class="form-control mb-2" id="clinicEmail" placeholder="Email Address"/>
                                <input type="text" class="form-control mb-2" id="clinicUsername" placeholder="Username"/>
                                <input type="password" class="form-control mb-2" id="clinicPassword" placeholder="Password"/>
                                <button class="btn btn-success mt-2 " onClick={createClinic}>Create</button>
                        </div>
                        <div class="card p-3 mt-3">
                            <h6 className="m-auto mb-2">Delete Clinic</h6>
                            <div class="row">
                                <div class="col-9">
                                    <input type="text" class="form-control" id="clinicId" placeholder="Email Address"/>
                                </div>
                                <div class="col">
                                    <button class="btn btn-danger  w-100" onClick={deleteClinic}>Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}