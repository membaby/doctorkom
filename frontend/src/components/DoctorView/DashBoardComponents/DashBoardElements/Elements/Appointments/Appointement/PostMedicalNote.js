export default function PostMedicalNote(medicalNote){
    fetch('http://localhost:8080/doctor/medical-note', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(medicalNote),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        return data;
    })
}