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

export default Clinic;