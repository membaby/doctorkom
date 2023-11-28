import React, {useState} from "react";
import {useParams} from "react-router-dom"

export default function Verification() {
    const {email, code} = useParams();
    var xhr = new XMLHttpRequest()
    let {message, setMessage} = useState("Waiting for response");
    xhr.addEventListener('load', () => {setMessage(xhr.responseText)})
    xhr.open('POST', 'http://localhost:8080/verify?email=' + email + '&code=' + code)
    xhr.send()

    return (
        <div>
            <h1 className="text-center text-primary">{message ? message : "Couldn't reach server."}</h1>
        </div>
    )
}