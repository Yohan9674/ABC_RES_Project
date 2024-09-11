function validateForm() {
    var name = document.getElementById("name").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var telephone = document.getElementById("telephone").value;

    if (name == "" || username == "" || password == "" || email == "" || telephone == "") {
        alert("All fields must be filled out");
        return false;
    }
    return true;
}
