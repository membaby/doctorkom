// Your React component file

import React, { useState, useRef, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './DashElement.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

export default function DashElement(props) {
    const [isVisible, setIsVisible] = useState(false);
    const contentRef = useRef(null);
    const id = props.id;

    useEffect(() => {
        if (contentRef.current) {
            contentRef.current.style.maxHeight = isVisible ? `${contentRef.current.scrollHeight}px` : '0';
        }
    }, [isVisible]);

    const toggleVisibility = () => {
        setIsVisible(!isVisible);
    };

    return (
        <div className={`container myContainer ${isVisible ? 'expanded' : ''}`} id={id}>
            <div className="d-flex justify-content-between list-group-item rounded-3 py-3 noBorder">
                <div className="mb-0 biggerThickerText">
                    {props.name}
                    <span className="d-block small mb-0 opacity-75">{props.description}</span>
                </div>
                <button className="btn btn-primary myButton" onClick={toggleVisibility}>
                    {isVisible ? 'Hide' : 'Show'} <i className={`bi bi-caret-${isVisible ? 'up' : 'down'}-fill arrow-down`}></i>
                </button>
            </div>
            <div ref={contentRef} className={`content list__height ${isVisible ? 'visible' : ''}`}  >
                {props.div}
            </div>
        </div>
    );
}
