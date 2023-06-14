/**
 * 
 */

 document.getElementById('registro-form').addEventListener('submit', function(e) {
  e.preventDefault();
  let email = document.getElementById('registro-email').value;
  let password = document.getElementById('registro-password').value;
  fetch('http://localhost:8080/api/register', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({email: email, password: password})
  })
  .then(response => response.json())
  .then(data => {
    if (data.id) {
      alert('Usuario registrado con éxito');
    } else {
      alert('Error al registrar');
    }
  });
});

document.getElementById('login-form').addEventListener('submit', function(e) {
  e.preventDefault();
  let email = document.getElementById('login-email').value;
  let password = document.getElementById('login-password').value;
  fetch('http://localhost:8080/api/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({email: email, password: password})
  })
  .then(response => response.json())
  .then(data => {
    if (data.id) {
      alert('Inicio de sesión exitoso');
      loadWorkouts();
    } else {
      alert('Error al iniciar sesión');
    }
  });
});

document.getElementById('workout-form').addEventListener('submit', function(e) {
  e.preventDefault();
  let nombre = document.getElementById('workout-name').value;
  fetch('http://localhost:8080/api/workouts', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({nombre: nombre})
  })
  .then(response => response.json())
  .then(data => {
    if (data.id) {
      loadWorkouts();
    } else {
      alert('Error al agregar la rutina');
    }
  });
});

function loadWorkouts() {
  fetch('http://localhost:8080/api/workouts')
    .then(response => response.json())
    .then(data => {
      let rutinasDiv = document.getElementById('workouts-div');
      rutinasDiv.innerHTML = '';
      data.forEach(rutina => {
        let p = document.createElement('p');
        p.textContent = rutina.nombre;
        rutinasDiv.appendChild(p);
      });
    });
}
