// Sample list of restaurant services and facilities
const services = [
    {
        title: 'Free Wi-Fi',
        description: 'Enjoy complimentary Wi-Fi while dining at our restaurant.',
        image: 'img/free-wifi.jpg'
    },
    {
        title: 'Outdoor Seating',
        description: 'Relax and dine in our beautiful outdoor seating area.',
        image: 'img/s1.jpg'
    },
    {
        title: 'Private Dining Room',
        description: 'We offer a private dining room for special events and gatherings.',
        image: 'img/s2.jpg'
    },
    {
        title: 'Wheelchair Accessible',
        description: 'Our restaurant is fully wheelchair accessible for your convenience.',
        image: 'img/s3.jpg'
    },
    {
        title: 'Kids Menu',
        description: 'A special menu designed with your kids in mind.',
        image: 'img/s4.jpg'
    },
    {
        title: 'Valet Parking',
        description: 'We offer valet parking for a convenient dining experience.',
       image: 'img/s5.jpg'
    },
    {
        title: 'Pet-Friendly',
        description: 'Bring your furry friend along to dine in our pet-friendly area.',
       image: 'img/s6.jpg'
    },
    {
        title: 'Live Music',
        description: 'Enjoy live music performances on select evenings.',
       image: 'img/s7.jpg'
    }
];

// Function to load services dynamically
function loadServices() {
    const servicesList = document.getElementById('services-list');
    servicesList.innerHTML = ''; // Clear existing services

    services.forEach(service => {
        const serviceCard = document.createElement('div');
        serviceCard.className = 'service-card';

        serviceCard.innerHTML = `
            <img src="${service.image}" alt="${service.title}">
            <h3>${service.title}</h3>
            <p>${service.description}</p>
        `;

        servicesList.appendChild(serviceCard);
    });
}

// Function to filter services based on search input
function filterServices() {
    const searchValue = document.getElementById('search-input').value.toLowerCase();
    const serviceCards = document.querySelectorAll('.service-card');

    serviceCards.forEach(card => {
        const title = card.querySelector('h3').textContent.toLowerCase();
        const description = card.querySelector('p').textContent.toLowerCase();

        if (title.includes(searchValue) || description.includes(searchValue)) {
            card.classList.remove('hidden');
        } else {
            card.classList.add('hidden');
        }
    });
}

// Add event listener to search input for real-time filtering
document.getElementById('search-input').addEventListener('input', filterServices);

// Initialize the page by loading services
loadServices();
