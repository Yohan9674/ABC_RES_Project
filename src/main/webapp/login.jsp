<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
    <div class="login-container">
        <div class="form-wrapper">
            <h2>Login</h2>
            <form action="LoginServlet" method="post">
                <div class="input-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <!-- Display error message if login fails -->
                <div class="error-message">
                    <c:if test="${not empty errorMessage}">
                        <p class="error-text">${errorMessage}</p>
                    </c:if>
                </div>

                <div class="button-group">
                    <input type="submit" value="Login" class="btn">
                    <a href="home.html" class="btn-back">Back to Home</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
