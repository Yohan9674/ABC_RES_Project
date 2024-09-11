document.getElementById('payment-form').addEventListener('submit', function (event) {
    event.preventDefault();

    // Get form values
    const paymentMethod = document.getElementById('payment-method').value;
    const amountDeposit = document.getElementById('amount-deposit').value;
    const balance = document.getElementById('balance').value;
    const paymentStatus = document.getElementById('payment-status').value;

    // Create a unique Payment ID
    const paymentID = 'PAY' + Math.floor(Math.random() * 100000);

    // Add new row to the table
    const tableBody = document.getElementById('payment-table-body');
    const newRow = tableBody.insertRow();

    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    const cell3 = newRow.insertCell(2);
    const cell4 = newRow.insertCell(3);
    const cell5 = newRow.insertCell(4);

    cell1.textContent = paymentID;
    cell2.textContent = paymentMethod;
    cell3.textContent = amountDeposit;
    cell4.textContent = balance;
    cell5.textContent = paymentStatus;

    // Clear form fields after submission
    document.getElementById('payment-form').reset();
});
