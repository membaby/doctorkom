import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';


export default function About() {
    return (
        <div class="container mt-5">
        <h1 class="text-center">Welcome to Doctorkom</h1>
    
        <section class="mt-4">
          <h2>Empowering Your Healthcare Journey</h2>
          <p>Doctorkom is your go-to digital platform for simplifying healthcare appointments. We understand the importance
            of convenient and efficient healthcare access, and our platform connects patients, doctors, and clinics in a
            seamless way.</p>
        </section>
    
        <section class="mt-4">
          <h2>How Doctorkom Works</h2>
          <p>For Patients: Easily schedule your appointments with healthcare providers of your choice. Say goodbye to long
            waiting times and enjoy the convenience of managing your healthcare on your terms.</p>
    
          <p>For Doctors: Streamline your appointment management with our user-friendly platform. Reach more patients and
            focus on what you do best – providing quality care.</p>
    
          <p>For Clinics: Optimize your operations by integrating Doctorkom into your practice. Improve patient
            accessibility and enhance the overall healthcare experience at your clinic.</p>
        </section>
    
        <section class="mt-4">
          <h2>Our Technology</h2>
          <p>Doctorkom utilizes cutting-edge technology to enhance your healthcare experience. Our platform is built with a
            modern and secure frontend powered by ReactJS, ensuring a smooth user interface. On the backend, we rely on the
            robust and scalable Spring Boot framework to provide a secure and efficient foundation.</p>
        </section>
    
        <section class="mt-4">
          <h2>Explore Doctorkom</h2>
          <p>Discover the future of healthcare appointments with Doctorkom. Whether you're a patient seeking convenience,
            a doctor looking to streamline appointments, or a clinic aiming to enhance patient care – we've got you
            covered.</p>
    
          <p>For more in-depth information about our project, please visit our <a href="https://github.com/membaby/doctorkom">GitHub repository</a>.</p>
    
          <p>If you have any questions or need assistance, feel free to reach out to us. Your health is our priority!</p>
        </section>
      </div>    
    )
}