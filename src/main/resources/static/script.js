const params = new URLSearchParams(location.search);
const user = params.get("user");

function rentCar(vehicleId) {
    const url = "/rent-vehicle?user=" + user + "&vehicleId=" + vehicleId;
    fetch(url, {
        method: "POST"
    }).then(res => {
        if (res.status === 200) {
            alert("Bill to rent car has been generated");
        } else {
            alert("Could not rent the car");
        }
    }).catch(err => {
        alert("Could not rent the car");
    })
}

var homeLink = document.getElementById("homeLink");
var bookingLink = document.getElementById("bookingLink");
console.log(homeLink);

homeLink.setAttribute('href', '/home?user=' + user);
bookingLink.setAttribute('href', '/bookings?user=' + user);
