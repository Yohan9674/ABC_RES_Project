<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Include JSTL library -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation</title>
    <link rel="stylesheet" href="reservation.css">
</head>
<body>

    <!-- Navigation Header -->
    <header>
        <nav>
            <div class="logo">
                <img src="img/logow.png" alt="ABC Restaurant Logo"> <!-- Replace with your logo path -->
            </div>
            <ul class="nav-links">
                <li><a href="home.html">Home</a></li>
                <li><a href="ourmenu.html">Our Menu</a></li>
                <li><a href="services.html">Services and Facilities</a></li>
                <li><a href="reservation.jsp">Reservations</a></li>
                <li><a href="gallery.html">Gallery</a></li>
                <li><a href="aboutus.html">About Us</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
            <div class="header-buttons">
                <a href="login.jsp" class="btn login-btn">Login</a>
                <a href="register.jsp" class="btn register-btn">Register</a>
            </div>
            <div class="menu-toggle">
                <i class="fas fa-bars"></i>
            </div>
        </nav>
    </header>
    
    <!-- Reservation Form -->
    <h2>Make a Reservation</h2>
    
    <form action="reservation" method="post">
        <!-- Form Fields: name, email, phone, date, time, persons, message -->
        <input type="text" name="name" placeholder="Your Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="tel" name="phone" placeholder="Phone" required>
        <input type="date" name="date" required>
        <input type="time" name="time" required>
        <input type="number" name="persons" placeholder="Number of Persons" min="1" max="20" required>
        <textarea name="message" placeholder="Any Message" required></textarea>
        <button type="submit">Book Now</button>
    </form>

    <!-- Display the reservation status -->
    <h3>${status}</h3>

    <!-- Conditional "Make a Payment" button -->
   <c:choose>
    <c:when test="${status == 'Reservation confirmed!'}">
        <!-- Show the payment button when reservation is confirmed -->
        <form action="payment.jsp" method="post">
            <input type="hidden" name="reservationId" value="${reservationId}"> <!-- Pass reservation ID if needed -->
            <button type="submit">Make a Payment</button>
        </form>
    </c:when>
    <c:otherwise>
        <!-- Hide the button when reservation is not confirmed -->
       <p>${status == 'Sorry, the date is fully booked. Please try another day.' ? 'Unfortunately, no payment is required.' : ''}</p>
    </c:otherwise>
</c:choose>

    <!-- Footer -->
    <footer>
        <div class="footer-container">
            <div class="footer-logo">
                <img src="img/logow.png" alt="Company Logo"> <!-- Replace with your logo path -->
                <p class="footer-description">Stay connected and be informed about our activities, programs, and assistance schemes.</p>
            </div>

            <div class="footer-links">
                <div class="footer-section">
                    <h5>Address</h5>
                    <p>
                        ABC Restaurant,<br>
                        No 42, Example Street,<br>
                        Colombo,<br>
                        Sri Lanka.
                    </p>
                </div>

                <div class="footer-section">
                    <h5>Navigation</h5>
                    <ul>
                        <li><a href="aboutus.html">About Us</a></li>
                        <li><a href="contact.html">Contact Us</a></li>
                        <li><a href="terms.html">Terms and Conditions</a></li>
                    </ul>
                </div>

                <div class="footer-section">
                    <h5>Related Links</h5>
                    <ul>
                        <li><a href="https://www.srilankabusiness.com/">Sri Lanka Export Development Board</a></li>
                        <li><a href="https://mip.gov.lk/">Ministry of Investment Promotion</a></li>
                        <li><a href="https://www.slab.lk/">Sri Lanka Accreditation Board</a></li>
                        <li><a href="https://www.slsi.lk/">Sri Lanka Standards Institution</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>

</body>
</html>
