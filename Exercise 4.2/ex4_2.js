document.getElementById('timeButton').addEventListener('click', function() {
    setInterval(updateTime, 1000);
});

function updateTime() {
    const now = new Date();
    document.getElementById('timeDisplay').textContent = now.toLocaleTimeString();
}

// Cursor hover effects
const hoverParagraph = document.getElementById('hoverParagraph');
const cursorStatus = document.getElementById('cursorStatus');

hoverParagraph.onmouseenter = () => cursorStatus.textContent = 'Cursor is on the text';
hoverParagraph.onmouseleave = () => cursorStatus.textContent = 'Cursor is away from the text';

// Image hover effects
const hoverImage = document.getElementById('hoverImage');
const hoverText = document.getElementById('hoverText');

hoverImage.onmouseenter = () => {
    hoverImage.style.transform = 'translateY(10px)'; // Move image down
    hoverText.style.display = 'block'; // Show hover text
};

hoverImage.onmouseleave = () => {
    hoverImage.style.transform = 'translateY(0)'; // Move image back
    hoverText.style.display = 'none'; // Hide hover text
};

// One-time gradient color change
document.body.onclick = () => {
    document.body.style.background = "red";
};
