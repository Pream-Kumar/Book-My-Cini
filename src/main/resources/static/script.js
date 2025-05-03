const apiBase = 'http://localhost:8080/api/user'; // change as per your backend

// LOGIN
document.getElementById('loginForm')?.addEventListener('submit', async (e) => {
  e.preventDefault();
  const username = document.getElementById('login-username').value;
  const password = document.getElementById('login-password').value;

  const res = await fetch(`${apiBase}/login`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username, password })
  });

  if (res.ok) {
    const data = await res.json();
    localStorage.setItem('token', data.token);
    alert('Login successful!');
    // Redirect or do something
  } else {
    alert('Invalid login');
  }
});

// REGISTER
document.getElementById('registerForm')?.addEventListener('submit', async (e) => {
  e.preventDefault();
  const username = document.getElementById('register-username').value;
  const email = document.getElementById('register-email').value;
  const phonenumber = document.getElementById('register-phonenumber').value;
  const password = document.getElementById('register-password').value;

  const res = await fetch(`${apiBase}/register`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username, email, phonenumber, password })
  });

  if (res.ok) {
    alert('Registration successful! Please login.');
    window.location.href = 'login.html';
  } else {
    alert('Registration failed');
  }
});
