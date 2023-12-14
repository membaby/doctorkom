export default function setUserInfo(role, data) {
    if (!role || !data) {
      return Promise.reject("Role and data required.");
    }
  
    return fetch(`http://localhost:8080/${role.toLowerCase()}/profile`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
        })
        .then(response => {
            return true;
        })
        .catch(error => {
            console.error("Error fetching user info:", error);
            throw new Error("Error fetching user info.");
    });
}  