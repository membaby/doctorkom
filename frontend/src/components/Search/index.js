import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function Search() {


    return (
        <div>
            <div class="container py-4 py-xl-5">
                <h3>Find Your Ideal Healthcare Provider</h3>
                <hr/>
                <div className="text-center">
                    <img src="/images/illustrations/Mental Therapy.gif" alt="ABC" width="300px" />
                    <div className="card">
                        <div className="card-body">
                            <div className="row">
                                <div className="col">
                                    <input type="text" className="form-control" placeholder="Doctor/Clinic Name" />
                                </div>
                                <div className="col-auto">
                                    <a href="#" className="btn btn-primary px-5">Search</a>
                                </div>
                            </div>

                            <div className="row mt-3">
                                <div className="col">
                                    <input type="text" className="form-control" placeholder="Doctor/Clinic Name" />
                                </div>
                                <div className="col-auto">
                                    <a href="#" className="btn btn-primary px-5">Search</a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    )
}