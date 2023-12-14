export default function getUserInfo(role, username) {
    if (!role || !username) {
      return Promise.reject("Role and username are required.");
    }
  
    return fetch(`http://localhost:8080/${role.toLowerCase()}/profile?username=${username}`, { method: 'GET' })
        .then(response => {
            if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .catch(error => {
            console.error("Error fetching user info:", error);
            throw new Error("Error fetching user info.");
    });
}  