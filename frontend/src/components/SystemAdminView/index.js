import React, {useState} from "react"
import bootstrap from 'react-bootstrap'
import AdminNavbar from "./AdminNavbar"

export default function SystemAdminView({account}){


    return(
        <div>
            <div className="fixed-top">
                <AdminNavbar />
            </div>
            <h1>{"You have admin access to the system"}</h1>
           <div></div>
        </div>
        
    )
}