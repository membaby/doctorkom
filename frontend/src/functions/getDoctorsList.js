export default function getDoctorsList(keyword, city, title, specialty, page) {
    let url = `http://localhost:8080/search/doctors?pageCount=${page}&`;
    if (keyword && keyword      !== "none") {url += `name=${keyword}&`}
    if (city && city            !== "none") {url += `city=${city}&`}
    if (title && title          !== "none") {url += `title=${title}&`}
    if (specialty && specialty  !== "none") {url += `specialty=${specialty}&`}

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