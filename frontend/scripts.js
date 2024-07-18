// Login form submission
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var formData = new FormData(this);
    fetch('/api/login', {
        method: 'POST',
        body: new URLSearchParams(formData)
    }).then(response => response.json())
      .then(data => {
          if (data.success) {
              window.location.href = 'class-selection.html';
          } else {
              alert('Login failed');
          }
      });
});

// Register form submission
document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var formData = new FormData(this);
    fetch('/api/register', {
        method: 'POST',
        body: JSON.stringify(Object.fromEntries(formData)),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
      .then(data => {
          if (data.success) {
              alert('Registration successful');
              window.location.href = 'login.html';
          } else {
              alert('Registration failed');
          }
      });
});

// Class selection
document.getElementById('selectClassButton').addEventListener('click', function() {
    var classId = document.getElementById('classSelect').value;
    window.location.href = 'assignments.html?classId=' + classId;
});

// Fetch assignments and submit assignment
document.addEventListener('DOMContentLoaded', function() {
    var classId = new URLSearchParams(window.location.search).get('classId');
    if (classId) {
        fetch('/api/assignments/class/' + classId)
            .then(response => response.json())
            .then(data => {
                var assignmentsList = document.getElementById('assignmentsList');
                assignmentsList.innerHTML = '';
                data.forEach(assignment => {
                    var assignmentDiv = document.createElement('div');
                    assignmentDiv.classList.add('assignment');
                    assignmentDiv.innerHTML = `<h3>${assignment.title}</h3>
                                                <p>${assignment.description}</p>
                                                <p><strong>Deadline:</strong> ${assignment.deadline}</p>`;
                    assignmentsList.appendChild(assignmentDiv);
                });
            });
    }

    document.getElementById('submitAssignmentForm').addEventListener('submit', function(event) {
        event.preventDefault();
        var formData = new FormData(this);
        fetch('/api/assignments/submit', {
            method: 'POST',
            body: formData
        }).then(response => response.json())
          .then(data => {
              if (data.success) {
                  alert('Assignment submitted successfully');
              } else {
                  alert('Submission failed');
              }
          });
    });
});

// Create assignment form submission
document.getElementById('createAssignmentForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var formData = new FormData(this);
    fetch('/api/assignments/create', {
        method: 'POST',
        body: JSON.stringify(Object.fromEntries(formData)),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
      .then(data => {
          if (data.success) {
              alert('Assignment created successfully');
          } else {
              alert('Creation failed');
          }
      });
});
