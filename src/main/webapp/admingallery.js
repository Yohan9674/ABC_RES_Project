// Get elements from the DOM
const addImageBtn = document.getElementById('add-image-btn');
const imageModal = document.getElementById('image-modal');
const closeModalBtn = document.querySelector('.close-modal');
const imageForm = document.getElementById('image-form');
const galleryGrid = document.querySelector('.gallery-grid');

// Open modal when clicking "Add Image" button
addImageBtn.addEventListener('click', () => {
    imageModal.style.display = 'block';
});

// Close modal when clicking the "X" button
closeModalBtn.addEventListener('click', () => {
    imageModal.style.display = 'none';
    resetForm();
});

// Close modal if clicking outside the modal content
window.addEventListener('click', (event) => {
    if (event.target == imageModal) {
        imageModal.style.display = 'none';
        resetForm();
    }
});

// Handle form submission for adding/updating images
imageForm.addEventListener('submit', (event) => {
    event.preventDefault();
    
    const fileInput = document.getElementById('image-file');
    const descriptionInput = document.getElementById('image-description');
    const file = fileInput.files[0];
    const description = descriptionInput.value;

    if (!file || !description) {
        alert("Please fill out both fields.");
        return;
    }

    // Create a new gallery item
    const reader = new FileReader();
    reader.onload = function (e) {
        const galleryItem = document.createElement('div');
        galleryItem.classList.add('gallery-item');

        galleryItem.innerHTML = `
            <img src="${e.target.result}" alt="${description}">
            <button class="update-image-btn">Update</button>
            <button class="delete-image-btn">Delete</button>
        `;

        // Append the new item to the gallery grid
        galleryGrid.appendChild(galleryItem);
        setUpGalleryButtons(galleryItem);

        // Close the modal and reset the form
        imageModal.style.display = 'none';
        resetForm();
    };

    reader.readAsDataURL(file);
});

// Set up event listeners for Update and Delete buttons dynamically
function setUpGalleryButtons(galleryItem) {
    const updateBtn = galleryItem.querySelector('.update-image-btn');
    const deleteBtn = galleryItem.querySelector('.delete-image-btn');

    // Update Image event
    updateBtn.addEventListener('click', () => {
        // Open the modal with the current image data for updating
        const imgSrc = galleryItem.querySelector('img').src;
        const imgDescription = galleryItem.querySelector('img').alt;

        document.getElementById('image-description').value = imgDescription;
        imageModal.style.display = 'block';

        imageForm.addEventListener('submit', (event) => {
            event.preventDefault();
            // Update the image and description in the gallery item
            galleryItem.querySelector('img').alt = document.getElementById('image-description').value;

            // Close modal after updating
            imageModal.style.display = 'none';
            resetForm();
        });
    });

    // Delete Image event
    deleteBtn.addEventListener('click', () => {
        galleryGrid.removeChild(galleryItem);
    });
}

// Function to reset the form
function resetForm() {
    document.getElementById('image-file').value = '';
    document.getElementById('image-description').value = '';
}
