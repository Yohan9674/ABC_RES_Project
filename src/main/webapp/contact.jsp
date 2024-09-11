<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script defer src="https://kit.fontawesome.com/a076d05399.js"></script>
     <link rel="stylesheet" type="text/css" href="contact.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <script defer src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="contact.js"></script>
</head>
<body>
    
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


    

    <div class="contact-form">
        <h2>Contact Us</h2>
        <form id="contactForm" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="subject">Subject:</label>
            <input type="text" id="subject" name="subject" required>
            
            <label for="message">Message:</label>
            <textarea id="message" name="message" required></textarea>
            
            <button type="submit">Submit</button>
        </form>
        
        <!-- Placeholder for the success message -->
        <div id="successMessage" class="success-message" style="display:none;"></div>
    </div>
    
    
    
    
    
    
        <!-- Footer -->
    <footer>
        <div class="footer-container">
            <div class="footer-logo">
                <img src="img/logow.png" alt="Company Logo"> <!-- Replace with your logo path -->
                <p class="footer-description">Subscribe to our newsletter to receive  </br>
                    upcoming promotions and events at  </br> ABC Restaurant</p>
            </div>
    
            <div class="footer-links">
                <div class="footer-section">
                    <h5>ADDRESS</h5>
                    <p>
                        ABC RESTAURANT,<br>
                        No 42, Nawam Mawatha,<br>
                        Colombo 02,<br>
                        Sri Lanka.
                    </p>
                </div>
    
                <div class="footer-section">
                    <h5>QUICK LINKS</h5>
                    <ul>
                        <li><a href="aboutus.html">About Us</a></li>
                        <li><a href="ourmenu.html">Our Menu</a></li>
                        <li><a href="gallery.html">Gallery</a></li>
                    </ul>
                    </ul>
                </div>
    
                <div class="footer-section">
                    <h5>OPENING HOURS</h5>
                    <ul>
                        <p>      MONDAY – THURSDAY      <br>   12.00 – 3.30 PM & 6.30 -10.30 PM         </p>
                        <br><br>
                        <p>      FRIDAY – SUNDAY      <br>   12.00 – 3.30 PM & 6.30 -10.30 PM        </p>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    
</body>
</html>
