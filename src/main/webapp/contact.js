$(document).ready(function () {
    $('#contactForm').on('submit', function (e) {
        e.preventDefault(); // Prevent the default form submission

        var formData = $(this).serialize(); // Serialize the form data
        var name = $('#name').val(); // Get the name for the success message

        $.ajax({
            type: 'POST',
            url: 'contact',
            data: formData,
            success: function () {
                // Display the personalized success message
                $('#successMessage').html('Thank you, ' + name + '! Your message has been sent.');
                $('#successMessage').show(); // Show the success message
                $('#contactForm')[0].reset(); // Reset the form fields
            },
            error: function () {
                alert('There was an error sending your message. Please try again.');
            }
        });
    });
});
