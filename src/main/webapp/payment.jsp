<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABC Restaurant - Payment</title>
    <link rel="stylesheet" href="payment.css">
   
     <script>
        function validateForm() {
            var paymentType = document.querySelector('input[name="paymentType"]:checked').value;
            var cardNumber = document.forms["paymentForm"]["cardNumber"].value;
            var expiryDate = document.forms["paymentForm"]["expiryDate"].value;
            var cvc = document.forms["paymentForm"]["cvc"].value;

            if (paymentType === "visa") {
                if (cardNumber.length !== 16) {
                    document.getElementById("error").innerHTML = "Card number must be 16 digits.";
                    return false;
                }
                if (expiryDate.length !== 5 || expiryDate.indexOf('/') === -1) {
                    document.getElementById("error").innerHTML = "Invalid expiry date format.";
                    return false;
                }
                if (cvc.length !== 3) {
                    document.getElementById("error").innerHTML = "CVC must be 3 digits.";
                    return false;
                }
            }
            return true;
        }

        function toggleCardInput() {
            var paymentType = document.querySelector('input[name="paymentType"]:checked').value;
            if (paymentType === "visa") {
                document.getElementById("cardDetails").style.display = "block";
            } else {
                document.getElementById("cardDetails").style.display = "none";
            }
        }
    </script>
</head>
<body>
    
      <!-- Header section starts -->
      <header>
        <a href="#" class="logo"><i class="fas fa-utensils"></i>ABC Restaurant</a>
        <div id="menu-bar" class="fas fa-bars"></div>
        <nav class="navbar">
            <a href="index.jsp">Home</a>
            <a href="gallery.html">Gallery</a>
            <a href="Product.html">Product and Service</a>
            <a href="Search.html">Search Facilities</a>
            <a href="reservation.jsp">Reservations</a>
            <a href="registerEmployee.jsp">Register</a>
            <div class="dropdown">
                <button class="dropbtn">Check Availability <i class="fa fa-caret-down"></i></button>
                <div class="dropdown-content">
                    <a href="#">Check Availability</a>
                    <a href="submit-query.jsp">Submit Queries</a>
                    <a href="payment.jsp">Make Payment</a>
                </div>
            </div>
            <a href="login.jsp">Login</a>
        </nav>
    </header>
  
      <!-- Header section ends -->
    

    <div class="payment-form">
        <h2>Make a Payment</h2>
        <form name="paymentForm" action="submit-payment" method="post" onsubmit="return validateForm()">
            <input type="text" name="reservationId" placeholder="Reservation ID" required>
            <input type="number" name="amount" placeholder="Amount" step="0.01" required>

            <label>Payment Type:</label>
            <input type="radio" name="paymentType" value="cash" checked onclick="toggleCardInput()"> Cash
            <input type="radio" name="paymentType" value="visa" onclick="toggleCardInput()"> Visa

            <div id="cardDetails" style="display: none;">
                <input type="text" name="cardNumber" placeholder="Card Number">
                <input type="text" name="nameOnCard" placeholder="Name on Card">
                <input type="text" name="expiryDate" placeholder="MM/YY">
                <input type="text" name="cvc" placeholder="CVC">
            </div>

            <div id="error" class="error-message"></div>
            <button type="submit">Confirm Payment</button>
            <a href="cancel-payment.jsp">Cancel Payment</a>
        </form>
    </div>
</body>
</html>
