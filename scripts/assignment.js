document.addEventListener('DOMContentLoaded', () => {
    const assignmentForm = document.getElementById('assignmentForm');
    const submissionStatus = document.getElementById('submissionStatus');

    assignmentForm.addEventListener('submit', (e) => {
        e.preventDefault();
        
        const assignment = document.getElementById('assignment').value;
        const fileInput = document.getElementById('file');
        const file = fileInput.files[0];

        if (file) {
            const reader = new FileReader();
            reader.onload = function() {
                const fileContent = reader.result;
                // Here you would normally send the file to the server
                console.log('Assignment:', assignment);
                console.log('File Content:', fileContent);
                
                submissionStatus.textContent = 'Assignment submitted successfully!';
            };
            reader.readAsText(file);
        } else {
            submissionStatus.textContent = 'Please select a file to upload.';
        }
    });
});
