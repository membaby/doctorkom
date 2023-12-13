import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './styles.css';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import { FaStar, FaRegStar } from 'react-icons/fa';
import  { useState, useEffect } from 'react';
import axios from 'axios';

const app=[
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  {
    doc:'sama zayed',
    date:'12/12/2023',
    time:'7pm'
  },
  
]



export default function ClinicHomePage() {

  
  function CustomPrevArrow(props) {
    const { onClick } = props;
    return (
      <button
        className="custom-arrow-button custom-prev-arrow"
        onClick={onClick}
      >
        {"<"}
      </button>
    );
  }

  function CustomNextArrow(props) {
    const { onClick } = props;
    return (
      <button
        className="custom-arrow-button custom-next-arrow"
        onClick={onClick}
      >
        {">"}
      </button>
    );
  }
  const renderStarRating = (rating) => {
    const fullStars = Math.floor(rating);
    const halfStar = rating % 1 !== 0;
  
    const stars = [];
    for (let i = 0; i < fullStars; i++) {
      stars.push(<FaStar key={i} color="#ffc107" />);
    }
  
    if (halfStar) {
      stars.push(<FaStar key="half" half color="#ffc107" />);
    }
  
    const emptyStars = 5 - (fullStars + (halfStar ? 1 : 0));
    for (let i = 0; i < emptyStars; i++) {
      stars.push(<FaRegStar key={`empty-${i}`} />);
    }
  
    return stars;
  };
  

  ///////////////////////////////////////////////////////////////apis////////////////////////////////////////////////
  ///////////////////////clinic info get request
const [rating, setRating] = useState(4.5);
const [name, setName] = useState('');
const [address, setAddress] = useState('');
const [phone, setPhone] = useState('');
const [email, setEmail] = useState('');
const [id, setId] = useState(80);////////////////////////assuming we have ID FROM COOKIES
const [landlinePhone, setLandlinePhone] = useState('');
const [admin, setAdmin] = useState({});

// useEffect(() => {
// const GetClinicObject= async () => {
//   try {
//     const url = 'http://localhost:8080/Clinic/Clinic';
//     const postData = {
//       id: 80
//     };
//     const response = await axios.post(url, {id:id});
//     console.log('POST request successful');
//     console.log(response.data); //the clinic object 
//     updateStateWithReturnedData(response.data);
//   } catch (error) {
//     console.error('Error making POST request:', error);
//   }
// };

//   const updateStateWithReturnedData = (data) => {
//     setName(data.name);
//     setAddress(data.address);
//     setPhone(data.phone);
//     setEmail(data.email);
//     // setId(data.id);
//     setLandlinePhone(data.landlinePhone);
//     setAdmin(data.admin);
//   };

 
//     GetClinicObject();
//   }, []); // empty dependency array ensures the effect runs only once on mount
useEffect(() => {
  fetch('http://localhost:8080/Clinic/Clinic', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(id),
})
.then(response => response.json())
.then(response => {
    // DO SOMETHING WITH THE RESPONSE
    setName(response.name);
    setAddress(response.address);
    setPhone(response.mobilePhone);
    setEmail(response.email);
    // setId(response.id);
    setLandlinePhone(response.landlinePhone);
    setAdmin(response.admin);   
})
.catch((error) => {
    console.log('Error occured. Please try again later.')
});
  }, []);

  ////////////////////////////adding doctors post request/////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  const [doctorEmail, setDoctorEmail] = useState('');
  const [doctorFees, setDoctorFees] = useState('');
  const [successMessage, setSuccessMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const clinicObject = {
    "id": id,
    "name": name,
    "address": address,
    "email": email,
    "mobilePhone": phone,
    "landlinePhone": landlinePhone,
    "admin": admin
  };
  // Event handler for updating doctorEmail state
  const handleDocEmailChange = (event) => {
    setDoctorEmail(event.target.value);
  };

  // Event handler for updating doctorFees state
  const handleFeesChange = (event) => {
    setDoctorFees(event.target.value);
  };
  const [isSubmitting, setIsSubmitting] = useState(false);
 
  const AddDoctor = async () => {
      try {
        // Make a POST request to your API endpoint
        setIsSubmitting(true); // Disable the button
        const response = await axios.post('http://localhost:8080/Clinic/AddDoctor', {
        email: doctorEmail,
        clinic: clinicObject,
        // doctorFees:doctorFees
        });
        while(response.data.message===null)
{}
        console.log(response.data.message);
         // Check the response and set messages accordingly
    if (response.data=='Doctor added successfully') {
      setSuccessMessage('Doctor added successfully');
      setErrorMessage(''); // Clear any previous error message
      // Clear input fields
      setDoctorEmail('');
      setDoctorFees('');
       
    } else if(response.data === 'Doctor not found') {
      // Handle other failure cases
      setSuccessMessage('');
      setErrorMessage(response.data || 'Doctor not found'); // Set error message
    }
    else if(response.data === 'Clinic not found') {
      // Handle other failure cases
      setSuccessMessage('');
      setErrorMessage(response.data.message || 'Clinic not found'); // Set error message
    }
    else if(response.data === 'Doctor already in the clinic') {
      // Handle other failure cases
      setSuccessMessage('');
      setErrorMessage('Doctor already in the clinic'); // Set error message
    }
    console.log(response.data);
  } catch (error) {
    // setSuccessMessage(''); 
    setErrorMessage('Error adding doctor'); 
    console.error('Error making POST request:', error);
  }
  finally {
    setIsSubmitting(false); // Enable the button
  }
    };
  ////////////////////////////edit clinic info post request/////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////////////////
  const [successMessage2, setSuccessMessage2] = useState('');
  const [errorMessage2, setErrorMessage2] = useState('');
  const [mockName, setMockName] = useState('');
  const [mockAddress, setMockAddress] = useState('');
  const [mockPhone, setMockPhone] = useState('');
  const [mockEmail, setMockEmail] = useState('');
  const handleMockName = (event) => {
      setMockName(event.target.value);
  };
  const handleMockAddress = (event) => {
      setMockAddress(event.target.value);
  };
  const handleMockPhone = (event) => {
      setMockPhone(event.target.value);
  };
  const handleMockEmail = (event) => {
      setMockEmail(event.target.value);
  };
  

  const EditInfo = async () => {
    try {
      let updatedInfo = {
        id: id,
        name: mockName !== '' ? mockName : name,
        address: mockAddress !== '' ? mockAddress : address,
        email: mockEmail !== '' ? mockEmail : email,
        mobilePhone: mockPhone !== '' ? mockPhone : phone,
        landlinePhone: landlinePhone, // Assuming landlinePhone doesn't change
        admin: admin, // Assuming admin doesn't change
      };
  
      const response = await axios.post('http://localhost:8080/Clinic/EditClinicInfo', updatedInfo);
  
      // Check the response and set messages accordingly
      if (response.data === 'Clinic edited') {
        setSuccessMessage2('Clinic Information is updated successfully');
        setErrorMessage2(''); // Clear any previous error message
      } else if (response.data === "Clinic Doesn't exist") {
        setSuccessMessage2(''); // Clear any previous success message
        setErrorMessage2("Clinic doesn't exist. Error editing clinic information");
      } else {
        // Handle other response 
      }
  
      console.log(response.data);
    } catch (error) {
      // Handle errors
      setSuccessMessage2(''); // Clear any previous success message
      setErrorMessage2('Error editing clinic information'); // Set error message
      console.error('Error making POST request:', error);
    }
  };

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////GET REQUEST TO GET DOCTORS OF THE CLINIC///////////////////////
  const [doctors, setDoctors] = useState([]);
  const [doctorsObjects,setDoctorsObjects]=useState([]);
  useEffect(() => {
  fetch('http://localhost:8080/Clinic/Doctors', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(clinicObject),
})
.then(response => response.json())
.then(response => {
    // DO SOMETHING WITH THE RESPONSE
    const doctorsData = response;
      const extractedDoctors = doctorsData.map(doctorInfo => ({
        name: `${doctorInfo.systemUser.firstName} ${doctorInfo.systemUser.lastName}`,
        title: doctorInfo.title,
        specialty: doctorInfo.specialty,
        email:doctorInfo.email
      }));
      setDoctorsObjects(response);
      setDoctors(extractedDoctors);
      
})
.catch((error) => {
    console.log('Error occured. Please try again later.')
});

  }, []);
 
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////POST REQUEST TO DELETE DOCTORS/////////////////////////////////////////
  const [doctorDeleteIndex, setDoctorDeleteIndex] = useState();

  
  const handleDelete = async (index) => {
    try {
      setDoctorDeleteIndex(index);
      console.log(doctorsObjects[0]);
      const email = doctorsObjects[index].systemUser.account.email;
      console.log('Doctor Email:', email);
      const response = await axios.post('http://localhost:8080/Clinic/RemoveDoctor', {
        email: email,
        clinic: clinicObject,
      });
      console.log(doctors);

    
    } catch (error) {
      console.error('Error deleting doctor:', error);
    }
    
     
  };
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  const settings = {
    dots: true,
    infinite: true,
    slidesToShow: doctors.length >= 3 ? 3 : doctors.length >= 2 ? 2 : 1,
    slidesToScroll: 1,
    speed: 3000,
    prevArrow: <CustomPrevArrow />,
    nextArrow: <CustomNextArrow />
  };

  return (
    <>
            <div id="root">
  <div class="container pt-5">
  
  <h3>{name}</h3>
                <hr/>
                <div className="container mt-5 container mt-27 mb-5">
      {/* Clinic Data */}
      <div className="row">
        <div className="col-md-6">
          <address>
            <strong>Address:</strong>
            {address}<br />
          </address>
       
        
          <p><strong>Phone:</strong>{phone}</p>
          </div>
          <div  className="col-md-6" >
          <p><strong>Email:</strong>{email}</p>
          <p>
            <strong>Rating:</strong>{renderStarRating(rating)}
          </p>
        </div>
      </div>
    </div>


    <div className="container">
  <div className="row">
    <div className="col-md-6">
      {/* Left side: Original appointment list */}
      <h3>Appointments</h3>
<hr/>
      <div style={{ height: '300px', overflowY: 'auto', border: '1px solid #ccc' }}>
        <ul style={{ listStyleType: 'none', padding: 0 }}>
          {app.slice(0, app.length).map((appointment, index) => (
            <li
              key={index}
              className="appointment-card"
              style={{
                backgroundColor: 'white',
                padding: '10px',
                marginBottom: '10px',
                boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
              }}
            >
              {/* ... (your existing code for appointment details) */}
              {app.slice(0,1).map((appointment, index) => (
          <li
            key={index}
            className="appointment-card"
            style={{
              backgroundColor: 'white',
              padding: '10px',
              marginBottom: '10px',
              boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
            }}
          >
            <div className="d-flex justify-content-between align-items-center">
              <p>
                <strong>Doctor:</strong> {appointment.doc}
                <span className="mx-2">|</span>
                <strong>Date:</strong> {appointment.date}
                <span className="mx-2">|</span>
                <strong>Time:</strong> {appointment.time}
              </p>

             <div className="button-container">
                <button type="button" className="btn  btn-danger  btn-sm">
                  Delete
                </button>
              </div>
            </div>
          </li>
        ))}
              
            </li>
          ))}
        </ul>
      </div>
    </div>

    <div className="col-md-6">
      {/* Right side: Duplicate appointment list */}
      <h3>Available Time Slots</h3>
<hr/>
      <div style={{ height: '300px', overflowY: 'auto', border: '1px solid #ccc' }}>
        <ul style={{ listStyleType: 'none', padding: 0 }}>
          {app.slice(0, app.length).map((appointment, index) => (
            <li
              key={index}
              className="appointment-card"
              style={{
                backgroundColor: 'white',
                padding: '10px',
                marginBottom: '10px',
                boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
              }}
            >
            
              {app.slice(0,1).map((appointment, index) => (
          <li
            key={index}
            className="appointment-card"
            style={{
              backgroundColor: 'white',
              padding: '10px',
              marginBottom: '10px',
              boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
            }}
          >
            <div className="d-flex justify-content-between align-items-center">
              <p>
                <strong>Doctor:</strong> {appointment.doc}
                <span className="mx-2">|</span>
                <strong>Date:</strong> {appointment.date}
                <span className="mx-2">|</span>
                <strong>Time:</strong> {appointment.time}
              </p>
              <div className="button-container">
              </div>
            </div>
          </li>
        ))}
            </li>
          ))}
        </ul>
      </div>
    </div>
  </div>
</div>

<div className="marginDiv"></div>

<h3>Our Doctors</h3>
                <hr/>
          {/* Doctor Cards */}
          <div className="row mt-5">
            <Slider {...settings}>
              {doctors.map((d, index) => (

<div key={index} className="c-dashboardInfo col-lg-3 col-md-6">
  <div className="docCard border rounded p-3">
    <div className="card-img-top rounded-top-xl bg-indigo-500 d-flex justify-content-center align-items-center">
      <img
        src={'images/profile.webp'}
        alt=""
        className="img-thumbnail rounded-circle"
        style={{ width: '120px', height: '120px' }}
      />
    </div>
    <div className="card-body d-flex flex-column justify-content-center align-items-center gap-4 p-4">
      {/* ... (your doctor card content, adjust as needed) */}
      <h5 className="heading heading5 hind-font medium-font-weight text-center decMar">{d.title}.{d.name}</h5>
      <h5 className="heading heading5 hind-font medium-font-weight decMar">Speciality:{d.speciality}</h5>
      <h5 className="heading heading5 hind-font medium-font-weight decMar">Fees:{d.fees}</h5>
      <button onClick={() => handleDelete(index)} type="button" className="btn btn-danger mb-3" style={{ marginTop: '1.5vw' }}>
        Delete
      </button>
    </div>
  </div>
</div>
              ))}
            </Slider>
          </div>
          <div className="marginDiv"></div>





<div className="marginDiv"></div>
<div className="container mt-4">
      <div className="row">
        <div className="col-md-6 ">
        <h3>Add Doctors</h3>
      <hr/>
      
          <div className="card flex-fill editCards">
            <div className="card-body">
              <h5 className="card-title">Doctor's Email</h5>
              <div className="form-group">
                <input type="email" value={doctorEmail} className="form-control" id="doctorEmail" placeholder="Enter doctor's email" onChange={handleDocEmailChange} />
              </div>
              <div style={{ marginBottom: '1.5vw' }}></div>
              <h5 className="card-title">Doctor's Fees</h5>
              <div className="form-group">
                <input type="fees"  value={doctorFees} className="form-control" id="doctorFees" placeholder="Enter doctor fees" onChange={handleFeesChange} />
              </div>
              <button disabled={isSubmitting} className="btn btn-success form-control" style={{ marginTop: '1.5vw' }} onClick={AddDoctor} >Add</button>
              <div style={{ marginBottom: '1.5vw' }}></div>
              {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
              {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
            </div>
          </div>
          
        </div>

        {/* Second Card - Address, Phone, Email */}
        <div className="col-md-6  ">
        <h3>Edit data</h3>
      <hr/>
          
          <div className="card flex-fill editCards">
            
            <div className="card-body">
              <h5 className="card-title">Edit Name, Address, Phone, Email</h5>
              <div className="form-group">
                <label htmlFor="address">Name:</label>
                <input type="text" className="form-control" onChange={handleMockName} id="address" placeholder="Enter New Name" />
              </div>
              <div className="form-group">
                <label htmlFor="address">Address:</label>
                <input type="text" className="form-control" onChange={handleMockAddress} id="address" placeholder="Enter Address" />
              </div>
              <div className="form-group">
                <label htmlFor="phone">Phone:</label>
                <input type="tel" className="form-control"  onChange={handleMockPhone}id="phone" placeholder="Enter Phone Number" />
              </div>
           
              <div className="form-group">
                <label htmlFor="email">Email:</label>
                <input type="email" className="form-control" onChange={handleMockEmail} id="email" placeholder="Enter email" />
              </div>
              <button className="btn btn-success form-control" style={{ marginTop: '1.5vw' }} onClick={EditInfo} >Apply changes</button>
              {successMessage2 && <p style={{ color: 'green' }}>{successMessage2}</p>}
              {errorMessage2 && <p style={{ color: 'red' }}>{errorMessage2}</p>}
            </div>
          </div>
        </div>
      </div>
    </div>

        </div>
      </div>
    </>
  );
}
