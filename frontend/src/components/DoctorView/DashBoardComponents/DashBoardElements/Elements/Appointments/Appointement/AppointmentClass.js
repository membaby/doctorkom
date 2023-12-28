class Appointment {
    constructor(timeSlot, patient) {
        this.timeSlot = new TimeSlot(
            timeSlot.clinic,
            timeSlot.doctor,
            timeSlot.date,
            timeSlot.startTime,
            timeSlot.endTime,
            timeSlot.reserved
        );

        this.patient = new Patient(
            patient.id,
            patient.occupation,
            patient.maritalStatus,
            patient.insurance,
            patient.systemUser
        );
    }
}

class Patient {
    constructor(id, occupation, maritalStatus, insurance, systemUser) {
        this.id = id;
        this.occupation = occupation;
        this.maritalStatus = maritalStatus;
        this.insurance = insurance;
        this.systemUser = new SystemUser(
            systemUser.id,
            systemUser.firstName,
            systemUser.lastName,
            systemUser.birthdate,
            systemUser.gender,
            systemUser.address,
            systemUser.mobilePhone,
            systemUser.landlinePhone,
            systemUser.account
        );
    }
}

class TimeSlot {
    constructor(clinic, doctor, date, startTime, endTime, reserved) {
        this.clinic = new Clinic(
            clinic.id,
            clinic.name,
            clinic.address,
            clinic.email,
            clinic.mobilePhone,
            clinic.landlinePhone,
            clinic.admin
        );

        this.doctor = new Doctor(
            doctor.id,
            doctor.title,
            doctor.specialty,
            doctor.systemUser
        );

        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserved = reserved;
    }
}

class Clinic {
    constructor(id, name, address, email, mobilePhone, landlinePhone, admin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.landlinePhone = landlinePhone;
        this.admin = new Admin(admin.id, admin.account.email, admin.account.username, admin.account.password, admin.account.role);
    }
}

class Admin {
    constructor(id, email, username, password, role) {
        this.id = id;
        this.account = new Account(id, email, username, password, role);
    }
}

class Account {
    constructor(id, email, username, password, role) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

class Doctor {
    constructor(id, title, specialty, systemUser) {
        this.id = id;
        this.title = title;
        this.specialty = specialty;
        this.systemUser = new SystemUser(systemUser.id, systemUser.firstName, systemUser.lastName, systemUser.birthdate, systemUser.gender, systemUser.address, systemUser.mobilePhone, systemUser.landlinePhone, systemUser.account);
    }
}

class SystemUser {
    constructor(id, firstName, lastName, birthdate, gender, address, mobilePhone, landlinePhone, account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.landlinePhone = landlinePhone;
        this.account = new Account(account.id, account.email, account.username, account.password, account.role);
    }
}

export default Appointment;
