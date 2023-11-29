import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function AdminHomePage() {
    return (
        <div>
            <div class="container py-4 py-xl-5">
                <h3>Admin Dashboard</h3>
                <hr/>

                <div class="row gy-4 row-cols-2 row-cols-md-4">
                    <div class="col">
                        <div class="text-center d-flex flex-column justify-content-center align-items-center py-3">
                            <div class="bs-icon-xl bs-icon-circle bs-icon-primary d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block mb-2 bs-icon lg"><svg class="bi bi-person" xmlns="http://www.w3.org/2000/svg" width="5em" height="5em" fill="currentColor" viewBox="0 0 16 16">
                                    <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"></path>
                                </svg></div>
                            <div class="px-3">
                                <h2 class="fw-bold mb-0">10,000</h2>
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
                                <h2 class="fw-bold mb-0">624</h2>
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
                                <h2 class="fw-bold mb-0">172</h2>
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
                                <h2 class="fw-bold mb-0">915</h2>
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
                                <input type="email" class="form-control" placeholder="User Email Address"/>
                                <textarea class="form-control mt-2" rows="4" placeholder="Notification Message"></textarea>
                                <button class="btn btn-primary mt-2 ">Send</button>
                        </div>
                        <div class="card p-3 mt-3">
                            <h6>Invite New Admin</h6>
                            <div class="row">
                                <div class="col-9">
                                    <input type="email" class="form-control" placeholder="User Email Address"/>
                                </div>
                                <div class="col">
                                    <button class="btn btn-warning  w-100">Invite</button>
                                </div>
                            </div>
                        </div>
                        <div class="card p-3 mt-3">
                            <h6>Deactive User Account</h6>
                            <div class="row">
                                <div class="col-9">
                                    <input type="email" class="form-control" placeholder="User Email Address"/>
                                </div>
                                <div class="col">
                                    <button class="btn btn-danger  w-100">Deactive</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <h4 class="text-center">Clinic Management</h4>
                        <div class="card p-3">
                            <h6>Create New Clinic</h6>
                                <input type="text" class="form-control mb-2" placeholder="Clinic Name"/>
                                <input type="text" class="form-control mb-2" placeholder="Clinic Admin Email"/>
                                <input type="text" class="form-control mb-2" placeholder="Full Address"/>
                                <input type="text" class="form-control mb-2" placeholder="Landline"/>
                                <input type="text" class="form-control mb-2" placeholder="Phone Number"/>
                                <button class="btn btn-success mt-2 ">Create</button>
                        </div>
                        <div class="card p-3 mt-3">
                            <h6>Deactive Clinic</h6>
                            <div class="row">
                                <div class="col-9">
                                    <input type="email" class="form-control" placeholder="Clinic Name"/>
                                </div>
                                <div class="col">
                                    <button class="btn btn-danger  w-100">Deactive</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}