// Sample queries data
const queries = [
    { id: 'QRY001', customerName: 'Yohan Ranasinghe', query: 'How can I reset my password?' },
    { id: 'QRY002', customerName: 'Dilini Amalsha', query: 'When will my order arrive?' },
    { id: 'QRY003', customerName: 'Luke Ranasinghe', query: 'Can I change my email address?' },
    { id: 'QRY004', customerName: 'Mark', query: 'How do I cancel my Reservation?' }
];

// Function to load queries into the table
function loadQueries() {
    const tableBody = document.getElementById('query-table-body');
    queries.forEach(query => {
        const newRow = document.createElement('tr');

        newRow.innerHTML = `
            <td>${query.id}</td>
            <td>${query.customerName}</td>
            <td>${query.query}</td>
            <td><button class="respond-btn" data-id="${query.id}">Respond</button></td>
        `;

        tableBody.appendChild(newRow);
    });

    // Add event listeners to respond buttons
    document.querySelectorAll('.respond-btn').forEach(button => {
        button.addEventListener('click', handleRespondClick);
    });
}

// Handle the click event for "Respond" buttons
function handleRespondClick(event) {
    const queryId = event.target.getAttribute('data-id');
    const query = queries.find(q => q.id === queryId);

    // Populate response form with query details
    document.getElementById('query-id').value = query.id;
    document.getElementById('customer-name').value = query.customerName;

    // Show the response section
    document.getElementById('response-section').classList.remove('hidden');
}

// Handle send response button
document.getElementById('send-response-btn').addEventListener('click', function() {
    const queryId = document.getElementById('query-id').value;
    const response = document.getElementById('response').value;

    if (!response) {
        alert('Please enter a response.');
        return;
    }

    alert(`Response sent for ${queryId}: ${response}`);

    // Hide the response section after sending
    document.getElementById('response-section').classList.add('hidden');
    document.getElementById('response').value = '';  // Clear the response field
});

// Handle cancel button
document.getElementById('cancel-btn').addEventListener('click', function() {
    // Hide the response section
    document.getElementById('response-section').classList.add('hidden');
    document.getElementById('response').value = '';  // Clear the response field
});

// Initialize the table with queries
loadQueries();
