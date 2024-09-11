// Sample reservations data
const reservations = [
    { id: 'RES001', name: 'Yohan', email: 'Yohan@gmail.com', phone: '0774709455', date: '2024-09-15', time: '19:00', persons: 2, message: 'Need a quiet table' },
    { id: 'RES002', name: 'Mark', email: 'Mark@gmail.com', phone: '0774709457', date: '2024-09-16', time: '20:00', persons: 4, message: 'Anniversary dinner' },
    { id: 'RES003', name: 'Luke', email: 'Luke@gmail.com', phone: '0774705478', date: '2024-09-17', time: '18:00', persons: 3, message: 'Vegetarian options needed' },
    { id: 'RES004', name: 'Hiruni', email: 'Hiruni@gmail.com', phone: '07747095321', date: '2024-09-18', time: '21:00', persons: 5, message: 'Celebrating birthday' }
];

// Function to load reservations into the table
function loadReservations() {
    const tableBody = document.getElementById('reservation-table-body');
    reservations.forEach(reservation => {
        const newRow = document.createElement('tr');

        newRow.innerHTML = `
            <td>${reservation.id}</td>
            <td>${reservation.name}</td>
            <td>${reservation.date}</td>
            <td>${reservation.time}</td>
            <td>${reservation.persons}</td>
            <td><button class="edit-btn" data-id="${reservation.id}">Edit</button></td>
        `;

        tableBody.appendChild(newRow);
    });

    // Add event listeners to edit buttons
    document.querySelectorAll('.edit-btn').forEach(button => {
        button.addEventListener('click', handleEditClick);
    });
}

// Handle the click event for "Edit" buttons
function handleEditClick(event) {
    const reservationId = event.target.getAttribute('data-id');
    const reservation = reservations.find(r => r.id === reservationId);

    // Populate form with reservation details
    document.getElementById('reservation-id').value = reservation.id;
    document.getElementById('customer-name').value = reservation.name;
    document.getElementById('email').value = reservation.email;
    document.getElementById('phone').value = reservation.phone;
    document.getElementById('date').value = reservation.date;
    document.getElementById('time').value = reservation.time;
    document.getElementById('persons').value = reservation.persons;
    document.getElementById('message').value = reservation.message;

    // Show the reservation details section
    document.getElementById('reservation-details-section').classList.remove('hidden');
}

// Handle update button
document.getElementById('update-btn').addEventListener('click', function() {
    const reservationId = document.getElementById('reservation-id').value;
    const reservation = reservations.find(r => r.id === reservationId);

    // Update reservation data
    reservation.name = document.getElementById('customer-name').value;
    reservation.email = document.getElementById('email').value;
    reservation.phone = document.getElementById('phone').value;
    reservation.date = document.getElementById('date').value;
    reservation.time = document.getElementById('time').value;
    reservation.persons = document.getElementById('persons').value;
    reservation.message = document.getElementById('message').value;

    // Reload the table to reflect changes
    document.getElementById('reservation-table-body').innerHTML = '';
    loadReservations();

    alert('Reservation updated successfully.');

    // Hide the reservation details section
    document.getElementById('reservation-details-section').classList.add('hidden');
});

// Handle delete button
document.getElementById('delete-btn').addEventListener('click', function() {
    const reservationId = document.getElementById('reservation-id').value;
    const index = reservations.findIndex(r => r.id === reservationId);

    if (index !== -1) {
        reservations.splice(index, 1); // Remove the reservation

        // Reload the table to reflect changes
        document.getElementById('reservation-table-body').innerHTML = '';
        loadReservations();

        alert('Reservation deleted successfully.');

        // Hide the reservation details section
        document.getElementById('reservation-details-section').classList.add('hidden');
    }
});

// Initialize the table with reservations
loadReservations();
