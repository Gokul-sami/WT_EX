document.getElementById('userDetailsForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nameInput = document.getElementById('userName');
    const emailInput = document.getElementById('userEmail');
    const ageInput = document.getElementById('userAge');
    const artistInput = document.getElementById('favoriteArtist');
    const genreInput = document.getElementById('userGenre');
    const commentsInput = document.getElementById('userComments');
    
    let isValid = true;

    // Validate name
    if (!/^[a-zA-Z\s]+$/.test(nameInput.value)) {
        alert('Name should only contain letters and spaces.');
        isValid = false;
    }

    // Validate email
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(emailInput.value)) {
        alert('Please enter a valid email address.');
        isValid = false;
    }

    // Validate age
    if (ageInput.value <= 0) {
        alert('Age must be a positive number.');
        isValid = false;
    }

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

// messages
const inputs = document.querySelectorAll('.form-control');

inputs.forEach(input => {
    input.addEventListener('input', function() {
        this.classList.add('shake'); 

        // Remove shake
        this.addEventListener('animationend', () => {
            this.classList.remove('shake');
        });

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
