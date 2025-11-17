document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('loginForm');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const errorMsg = document.getElementById('errorMsg');

    form.addEventListener('submit', (e) => {
        e.preventDefault(); // Αποτρέπει το default submit

        const username = usernameInput.value.trim();
        const password = passwordInput.value.trim();
        const time = new Date().toLocaleString();

        // Εκτύπωση πάντα στην κονσόλα
        console.log("=== Login Attempt ===");
        console.log("Time:", time);
        console.log("Username:", username);
        console.log("Password:", password);

        // Έλεγχος credentials
        if (username === "user" && password === "123gr") {
            console.log("Successful login!");
            errorMsg.textContent = ""; // Καθαρίζει το μήνυμα λάθους
            // Αφήνουμε λίγο χρόνο για να εμφανιστεί η κονσόλα
            setTimeout(() => {
                window.location.href = "app.html"; // Ανακατεύθυνση
            }, 200);
        } else {
            console.log("Failed login!");
            errorMsg.textContent = "Invalid username or password!";
        }
    });
});
