import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './styles.css';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import { FaStar, FaRegStar } from 'react-icons/fa';
import  { useState, useEffect } from 'react';
import axios from 'axios';
import secureLocalStorage from "react-secure-storage";

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

  useEffect(() => {
    const role = secureLocalStorage.getItem('role');
    const id = secureLocalStorage.getItem('id');
    const username = secureLocalStorage.getItem('username');

    if (!role || !id || !username || role !== 'CLINIC_ADMIN') {
      window.location.href = '/';
    }
  }, [])

  
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
const [id, setId] = useState(secureLocalStorage.getItem('id'));
const [landlinePhone, setLandlinePhone] = useState('');
const [admin, setAdmin] = useState({});
 
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
//   useEffect(() => {
//   fetch('http://localhost:8080/Clinic/Doctors', {
//     method: 'POST',
//     headers: {
//         'Content-Type': 'application/json'
//     },
//     body: JSON.stringify(clinicObject),
// })

// .then(response => response.json())
// .then(response => {
//     // DO SOMETHING WITH THE RESPONSE
//       const doctorsData = response;
//       const extractedDoctors = doctorsData.map(doctorInfo => ({
//         name: `${doctorInfo.systemUser.firstName} ${doctorInfo.systemUser.lastName}`,
//         title: doctorInfo.title,
//         specialty: doctorInfo.specialty,
//         email:doctorInfo.email
//       }
      
//       ));
     
      
//       setDoctorsObjects(response);
//       setDoctors(extractedDoctors);
//       // console.log(doctors);
//       console.log("yaraab");
//       console.log(doctorsObjects);
// })
// .catch((error) => {
//     console.log('Error occured. Please try again later.')
// });
     
     

//   }, []);
useEffect(() => {
  fetch('http://localhost:8080/Clinic/Doctors', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(clinicObject),
  })
    .then((response) => response.json())
    .then((doctorsData) => {
      console.log(doctorsData);
      
      const extractedDoctors = doctorsData.map((doctorInfo) => ({
        name: `${doctorInfo.systemUser.firstName} ${doctorInfo.systemUser.lastName}`,
        title: doctorInfo.title,
        specialty: doctorInfo.specialty,
        email: doctorInfo.email,
      }));

      // Set the state after mapping the data
      setDoctors(extractedDoctors);
      setDoctorsObjects(doctorsData);

      // Debugging logs
      console.log('Doctors:', extractedDoctors);
      console.log('DoctorsObjects:', doctorsData);
    })
    .catch((error) => {
      console.log('Error occurred. Please try again later.', error);
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
  ///////////////////////////////////////////post request to get appointments and timeslots//////////////////////////////////////////////
  const [timeslots, setTimeslots] = useState([]);
  const [appointments, setAppointments] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/Clinic/Appointments&TimeSlots', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(clinicObject),
        });

        if (response.ok) {
          const data = await response.json();
          setTimeslots(data[1]);
          setAppointments(data[0]);
          console.log("ok");
          // console.log(timeslots);
        } else {
          console.error('Error:', response.status);
        }
      } catch (error) {
        console.error('Error:', error);
      }
    };

    fetchData();
  }, []);
  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////POST REQUEST FOR DELETE APPOINTMENT/////////////////////////////////////////////
  const handleDeleteAppointement = async (app) => {
    try {
      const response = await fetch(' http://localhost:8080/Clinic/RemoveAppointment', {
    
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          // Add any additional headers if needed
        },
        body: JSON.stringify({doctor: app.timeSlot.doctor,
          clinic:  app.timeSlot.clinic,
          patient: app.patient,
          timeSlot: {
            date: app.timeSlot.date,
            startTime: app.timeSlot.startTime,
            endTime: app.timeSlot.endTime,
            reserved: true,
          },
          status: '',
         }),
      });

      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
      const responseData = await response.json();
      console.log('Response data:', responseData);
      if (responseData.data==="Appointment Doesn't exist") {
      }
      else if(responseData.data==="Appointment Deleted successfully"){

      }
     
    } catch (error) {
      console.error('Error:', error.message);
    }
  };

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////POST REQUEST FOR DELETE timeslot/////////////////////////////////////////////
  const handleDeleteTimeSlot = async (ts) => {
    try {
      const response = await fetch('http://localhost:8080/Clinic/RemoveTimeSlot', {
    
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          // Add any additional headers if needed
        },
        body: JSON.stringify({
          clinic:  ts.clinic,
          doctor: ts.doctor,
          date: ts.date,
          startTime: ts.startTime,
          endTime: ts.endTime,
          reserved: true,
         }),
      });
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
      const responseData = await response.json();
      console.log('Response data:', responseData);

     
      if (responseData.data==="Time slot doesn't exist") {
      }
      else if(responseData.data==="Time slot removed successfully"){

      }
     
    } catch (error) {
      console.error('Error:', error.message);
    }
  };
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////post request for adding timeslots////////////////////////////////////////////
  const addTimeslot = () => {
    const doctorId = document.getElementById('doctorId').value;
    console.log(doctorsObjects);
    const doctorDTO = doctorsObjects.find((doctor) => doctor.id === parseInt(doctorId));

    const timeSlotData = {
        clinic: clinicObject,
        doctor: doctorDTO,
        date: date,
        startTime: startTime + ":00",
        endTime: endTime + ":00",
        reserved: false,
    };

    fetch('http://localhost:8080/Clinic/AddTimeSlot', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(timeSlotData),
    })
      .then((response) => response.json())
      .then((response) => {
        if (response.success) {
  
          console.log('Success:', response.message);
        } else {

          console.log('Error:', response.message);
        }
      })
      .catch((error) => {
        console.error('Error occurred:', error);
      });
  };











  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  const [selectedDoctor, setSelectedDoctor] = useState(null);
  const handleDoctorChange = (event) => {
    const docid=event.target.value;
    console.log(docid);

    console.log("yarab");

    setSelectedDoctor(findDoctorById(docid));
    console.log(selectedDoctor);
  };
  const findDoctorById = (id) => {
    console.log("here");
    const doc=doctorsObjects.find((doctor) => parseInt(doctor.id,10) === parseInt(id,10));
    console.log("cons");
    console.log(doc);
    const yourObject = {
      id: doc.id,
      title: doc.title,
      specialty: doc.specialty,
      systemUser: {
        id: doc.systemUser.id,
        firstName: doc.systemUser.firstName,
        lastName: doc.systemUser.lastName,
        birthdate: doc.systemUser.birthdate,
        gender: doc.systemUser.gender,
        address: doc.systemUser.address,
        mobilePhone: doc.systemUser.mobilePhone,
        landlinePhone: doc.systemUser.landlinePhone,
        account: {
          id: doc.systemUser.account.id,
          email: doc.systemUser.account.email,
          username: doc.systemUser.account.username,
          password: doc.systemUser.account.password,
          role: doc.systemUser.account.role,
        },
      },
    };
    console.log("your")
    console.log(yourObject);
    return yourObject;
}
 
useEffect(() => {
  console.log("a5r 7aga");
  console.log(selectedDoctor);
}, [selectedDoctor]);

  const [startTime, setStartTime] = useState('');

  const handleStartTimeChange = (event) => {
    setStartTime(event.target.value);
  };
  const [endTime, setEndTime] = useState('');

  const handleEndTimeChange = (event) => {
    setEndTime(event.target.value);
  };
  const [date, setDate] = useState('');

  const handleDateChange = (event) => {
    setDate(event.target.value);
  };
  
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
          {appointments.slice(0, 1).map((item, index) => (
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
              {appointments.slice(0,appointments.length).map((item, index) => (
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
                <ul class="list-unstyled">
                <strong>Doctor:</strong> {item.timeSlot.doctor.systemUser.account.username}
                <span className="mx-2">|</span>
                <strong>Date:</strong> {item.date}
                </ul>
                <ul class="list-unstyled">
                <strong>Start Time:</strong> {item.timeSlot.startTime}
                <span className="mx-2">|</span>
                <strong>End Time:</strong> {item.timeSlot.endTime}
                </ul>
              </p>

             <div className="button-container">
                <button type="button" className="btn  btn-danger  btn-sm"  onClick={() => handleDeleteAppointement(item)}>
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
          {timeslots.slice(0, 1).map((item, index) => (
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
            
              {timeslots.slice(0,timeslots.length).map((timeslots, index) => (
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
                <ul class="list-unstyled">
                <strong>Doctor:</strong> {timeslots.doctor.systemUser.firstName} {timeslots.doctor.systemUser.lastName}
                <span className="mx-2">|</span>
                <strong>Date:</strong> {timeslots.date}
                </ul>
                <ul class="list-unstyled">
                <strong>Start Time:</strong> {timeslots.startTime}
                <span className="mx-2">|</span>
                <strong>End Time:</strong> {timeslots.endTime}
                </ul>
              </p>
              <div className="button-container">
                <button type="button" className="btn  btn-danger  btn-sm"  onClick={() => handleDeleteTimeSlot(timeslots)}>
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
        src={'/images/avatar/default-doctor-male.png'}
        alt=""
        className="img-thumbnail rounded-circle"
        style={{ width: '120px', height: '120px' }}
      />
    </div>
    <div className="card-body d-flex flex-column justify-content-center align-items-center gap-4 p-4">
      {/* ... (your doctor card content, adjust as needed) */}
      <h5 className="heading heading5 hind-font medium-font-weight text-center decMar"><span className="text-muted h6">{d.title}</span><br/>{d.name}</h5>
      <h5 className="heading decMar text-muted h6">{d.specialty.replace("_", " ")}</h5>
      <h5 className="heading heading5 hind-font medium-font-weight decMar h6">Fees: <span className="text-success">$100</span></h5>
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



      <div className="marginDiv"></div>
      <h3>Add Time Slot</h3>
      <hr/>
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Select doctor</h5>
              <div>
  
  <select className="form-control" id="doctorId">
    <option value="" disabled selected>
      Select a doctor
    </option>
    {doctorsObjects.map((doctor) => (
      <option key={doctor.id} value={doctor.id}>
        {`${doctor.systemUser.firstName} ${doctor.systemUser.lastName}`}
      </option>


    ))}
  </select>
</div>



              <div style={{ marginBottom: '1.5vw' }}></div>
              <h5 className="card-title">Date</h5>
              <div className="form-group">
                <input   type="date" className="form-control" placeholder="Enter date in fotm of " onChange={handleDateChange} />
              </div>
              <div style={{ marginBottom: '1.5vw' }}></div>
              <h5 className="card-title">Start time</h5>
              <div className="form-group">
                <input type="time" className="form-control" placeholder="Enter Start time "  onChange={handleStartTimeChange}  />
              </div>
              <div style={{ marginBottom: '1.5vw' }}>
              <h5 className="card-title" >End time</h5>
              <div className="form-group">
                <input  type="time" className="form-control" placeholder="Enter Start time " onChange={handleEndTimeChange} />
              <button disabled={isSubmitting} className="btn btn-success form-control mt-3" onClick={addTimeslot} >Add</button>
              </div>
              </div>
              {/* {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
              {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}*/}
            </div> 
          </div>



    </div>

        </div>
      </div>
    </>
  );
}
