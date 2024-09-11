
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
