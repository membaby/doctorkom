import React, {useState} from "react"
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import bootstrap from 'react-bootstrap'
import AdminNavbar from "./AdminNavbar"
import AdminHomePage from "./AdminHomePage.js"

export default function SystemAdminView({account}){

    return(
        <div>
            <div className="fixed-top">
                <AdminNavbar />
            </div>
            <div class="empty_block d-block w-100"></div>
            <div className="mt-5">
                <Routes>
                    <Route index element={ <AdminHomePage/> } />
                </Routes>
            </div>
        </div>
        
    )
}