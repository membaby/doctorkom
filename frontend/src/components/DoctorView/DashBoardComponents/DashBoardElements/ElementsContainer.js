import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ElementsContainer(props) {
    const containerStyle = {
        minHeight: props.children ? `${props.children.length * 50}px` : '50px', // Set a minimum height or adjust as needed
    };

    return (
        <div className="list-group list-group-checkable d-grid gap-2 border-0" style={containerStyle}>
            {props.children}
        </div>
    );
}
