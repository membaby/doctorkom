import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ElementsContainer(props) {
    return (
        <div className="list-group list-group-checkable d-grid gap-2 border-0">
            {props.children}
        </div>
    )
}