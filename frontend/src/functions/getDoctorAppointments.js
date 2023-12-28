export default function getDoctorAppointments(doctorId) {
    let url = `http://localhost:8080/doctor/appointments?doctorId=${doctorId}`;

    return fetch(url, { method: 'GET' })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .catch(error => {
            console.error("Error fetching doctors list:", error);
            throw new Error("Error fetching doctors list.");
    });
}  