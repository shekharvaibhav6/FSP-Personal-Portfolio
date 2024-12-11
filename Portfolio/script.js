const toggleSwitch = document.getElementById('theme-toggle');
const body = document.body;

toggleSwitch.addEventListener('change', () => {
    if (toggleSwitch.checked) {
        body.classList.remove('light-mode');
        body.classList.add('dark-mode');
    } else {
        body.classList.remove('dark-mode');
        body.classList.add('light-mode');
    }
});

function toggleLike(element) {
    element.classList.toggle('liked');
    element.innerHTML = element.classList.contains('liked') ? '&#9829;' : '&#9825;';
}
document.getElementById('linkedin-icon').addEventListener('click', function () {
    fetch('http://localhost:8080/api/footer/linkedin')
      .then(response => response.text())
      .then(url => {
        window.open(url, '_blank'); // Redirect to LinkedIn in a new tab
      })
      .catch(error => console.error('Error fetching LinkedIn URL:', error));
});
  
document.getElementById('github-icon').addEventListener('click', function () {
    fetch('http://localhost:8080/api/footer/github')
    .then(response => response.text())
    .then(url => {
        window.open(url, '_blank');
    })
    .catch(error => console.error('Error fetching GitHub URL:', error));
});
document.getElementById('email-icon').addEventListener('click', function () {
    fetch('http://localhost:8080/api/footer/email')
    .then(response => response.text())
    .then(mailtoLink => {
        window.location.href = mailtoLink;
    })
    .catch(error => console.error('Error fetching email link:', error));
});
  
function downloadResume() {
    // Call backend API to trigger the download
    fetch('http://localhost:8080/api/resume/download', {
      method: 'GET',
    })
    .then((response) => {
        if (response.ok) {
            window.location.href = './images/VaibhavShekhar.pdf';
        } else {
            alert('Failed to download resume');
        }
    }).catch((error) => {
        console.error('Error:', error);
    });
}

const link = document.getElementById('skill');
link.addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = 'Skills.html';
});

const link2 = document.getElementById('project');
link2.addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = 'projects.html';
});

const link3 = document.getElementById('intern');
link3.addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = 'internships.html';
});

const link4 = document.getElementById('certify');
link4.addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = 'certification.html';
});


document.getElementById('contact-form').addEventListener('submit', function(e) {
    e.preventDefault();

    // Collect form data
    const formData = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        subject: document.getElementById('subject').value,
        message: document.getElementById('message').value,
    };

    // Send data to backend API
    fetch('http://localhost:8080/api/contact', {  // Backend URL
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
    .then(response => response.json())
    .then(data => {
        alert(data.message); // Display success message from backend
    })
    .catch(error => {
        alert('There was an error, please try again.');
    });
});

const projects = [
    { name: 'project1', displayName: 'Project 1' },
    { name: 'project2', displayName: 'Project 2' },
    { name: 'project3', displayName: 'Project 3' },
    { name: 'project4', displayName: 'Project 4' },
    { name: 'project5', displayName: 'Project 5' },
    { name: 'project6', displayName: 'Project 6' },
    { name: 'project7', displayName: 'Project 7' },
    { name: 'project8', displayName: 'Project 8' },
    { name: 'project9', displayName: 'Project 9' },
    { name: 'project10', displayName: 'Project 10' },
    { name: 'project11', displayName: 'Project 11' },
    { name: 'project12', displayName: 'Project 12' }
    // Add more projects here
];

const projectList = document.getElementById('project-list');

projects.forEach(project => {
    const link = document.createElement('a');
    link.href = `http://localhost:8080/api/view-project?name=${project.name}`;
    link.target = '_blank';
    link.textContent = `View ${project.displayName}`;
    projectList.appendChild(link);

    const br = document.createElement('br');
    projectList.appendChild(br);
});