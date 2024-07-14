// Login form handling
document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');

    loginForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        // Simple client-side validation (for demonstration purposes)
        if (username === 'student' && password === 'password') {
            alert('Login successful!');
            window.location.href = 'dashboard.html';
        } else {
            alert('Invalid credentials, please try again.');
        }
    });
});
