<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Dashboard - ABC Restaurant</title>
    <link rel="stylesheet" href="staffDashboard.css">
    
    <script>
        // Fetch user count from the servlet and update the DOM
        function updateUserCount() {
            fetch('userCount')
                .then(response => response.json())
                .then(data => {
                    document.getElementById('users').innerText = data.userCount;
                })
                .catch(error => console.error('Error fetching user count:', error));
        }

        // Call the function when the page loads
        window.onload = updateUserCount;
    </script>
  
</head>
<body>

    <div class="sidebar">
        <h2>Staff Dashboard</h2>
        <ul>
            <li><a href="staffDashboard">Dashboard</a></li>
            <li><a href="staffreservation.html">Manage Reservations</a></li>
            <li><a href="staffresponse.html">Respond to Queries</a></li>
            <li><a href="staffmanegepayment.html">Manage Payments</a></li>
            <li><a href="login.jsp" id="logout">Logout</a></li>
        </ul>
    </div>







    <div class="main-content">
        <header>
            <h1>Welcome, Staff</h1>
            <button id="logout-button">Logout</button>
        </header>
        <div class="widgets">
            <div class="widget">
                <h3>Total Orders</h3>
                <p id="total-orders">120</p>
            </div>
            <div class="widget">
                <h3>Menu Items</h3>
                <p id="menu-items">35</p>
            </div>
            <div class="widget">
                <h3>Employees</h3>
                <p id="employees">15</p>
            </div>
            <div class="widget">
                <h3>Users</h3>
                <p id="users">0</p>
            </div>
        </div>
    </div>
    <script src="staffDashboard.js"></script>
</body>
</html>
