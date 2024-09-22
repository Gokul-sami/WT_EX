document.getElementById('userDetailsForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Get input elements
    const nameInput = document.getElementById('userName');
    const emailInput = document.getElementById('userEmail');
    const ageInput = document.getElementById('userAge');
    const artistInput = document.getElementById('favoriteArtist');
    const genreInput = document.getElementById('userGenre');
    const commentsInput = document.getElementById('userComments');
    
    // Simple validation
    let isValid = true;

    // Validate name (only letters and spaces)
    if (!/^[a-zA-Z\s]+$/.test(nameInput.value)) {
        alert('Name should only contain letters and spaces.');
        isValid = false;
    }

    // Validate email format
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(emailInput.value)) {
        alert('Please enter a valid email address.');
        isValid = false;
    }

    // Validate age (positive number)
    if (ageInput.value <= 0) {
        alert('Age must be a positive number.');
        isValid = false;
    }

    // If all validations pass
    if (isValid) {
        const userDetails = {
            name: nameInput.value,
            email: emailInput.value,
            age: ageInput.value,
            favoriteArtist: artistInput.value,
            favoriteGenre: genreInput.value,
            comments: commentsInput.value
        };

        console.log('Form submitted successfully!', userDetails);
        alert('Form submitted successfully!');
    }
});

// Handle dynamic messages
const inputs = document.querySelectorAll('.form-control');

inputs.forEach(input => {
    input.addEventListener('input', function() {
        this.classList.add('shake'); // Add shake class

        // Remove shake class after animation ends
        this.addEventListener('animationend', () => {
            this.classList.remove('shake'); // Remove shake class
        });

        // Display message based on the input field
        if (this.id === 'userName') {
            const nameMessage = document.getElementById('nameMessage');
            nameMessage.textContent = `Hi, ${this.value}! Ready to jam?`;
            nameMessage.style.display = this.value ? 'block' : 'none'; // Show/hide based on input
        } else if (this.id === 'favoriteArtist') {
            const artistMessage = document.getElementById('artistMessage');
            artistMessage.textContent = `Awesome choice! I love ${this.value} too!`;
            artistMessage.style.display = this.value ? 'block' : 'none'; // Show/hide based on input
        } else if (this.id === 'userGenre') {
            const genreMessage = document.getElementById('genreMessage');
            genreMessage.textContent = `Nice! ${this.options[this.selectedIndex].text} is a great genre!`;
            genreMessage.style.display = this.value ? 'block' : 'none'; // Show/hide based on input
        }
    });
});
