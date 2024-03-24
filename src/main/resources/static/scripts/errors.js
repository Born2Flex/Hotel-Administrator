function showError(errorEl, message) {
    let errorElement = document.getElementById(errorEl);
    errorElement.textContent = message;
}

function clearError(errorEl) {
    let errorElement = document.getElementById(errorEl);
    errorElement.textContent = '';
}

console.log('errors.js loaded');