import Clinic from './ClinicClass.js'

export default function GetClinics() {
    const clinics = [
        new Clinic(1, "Clinic 1", "address 1", "email 1", "mobilePhone 1", "landlinePhone 1", { id: 1, account: { email: "email 1", username: "username 1", password: "password 1", role: "role 1" } }),
        new Clinic(2, "Clinic 2", "address 2", "email 2", "mobilePhone 2", "landlinePhone 2", { id: 2, account: { email: "email 2", username: "username 2", password: "password 2", role: "role 2" } }),
        new Clinic(3, "Clinic 3", "address 3", "email 3", "mobilePhone 3", "landlinePhone 3", { id: 3, account: { email: "email 3", username: "username 3", password: "password 3", role: "role 3" } }),
        new Clinic(4, "Clinic 4", "address 4", "email 4", "mobilePhone 4", "landlinePhone 4", { id: 4, account: { email: "email 4", username: "username 4", password: "password 4", role: "role 4" } }),
        new Clinic(5, "Clinic 5", "address 5", "email 5", "mobilePhone 5", "landlinePhone 5", { id: 5, account: { email: "email 5", username: "username 5", password: "password 5", role: "role 5" } }),
        new Clinic(6, "Clinic 6", "address 6", "email 6", "mobilePhone 6", "landlinePhone 6", { id: 6, account: { email: "email 6", username: "username 6", password: "password 6", role: "role 6" } }),
        new Clinic(7, "Clinic 7", "address 7", "email 7", "mobilePhone 7", "landlinePhone 7", { id: 7, account: { email: "email 7", username: "username 7", password: "password 7", role: "role 7" } }),
        new Clinic(8, "Clinic 8", "address 8", "email 8", "mobilePhone 8", "landlinePhone 8", { id: 8, account: { email: "email 8", username: "username 8", password: "password 8", role: "role 8" } }),
        new Clinic(9, "Clinic 9", "address 9", "email 9", "mobilePhone 9", "landlinePhone 9", { id: 9, account: { email: "email 9", username: "username 9", password: "password 9", role: "role 9" } }),
        new Clinic(10, "Clinic 10", "address 10", "email 10", "mobilePhone 10", "landlinePhone 10", { id: 10, account: { email: "email 10", username: "username 10", password: "password 10", role: "role 10" } }),
        new Clinic(11, "Clinic 11", "address 11", "email 11", "mobilePhone 11", "landlinePhone 11", { id: 11, account: { email: "email 11", username: "username 11", password: "password 11", role: "role 11" } })
    ];
    return clinics;
}