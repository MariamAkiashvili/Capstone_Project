const uploadButton = document.getElementById('openUploadModalButton');


uploadButton.addEventListener('click', () => {
    console.log("Upload button clicked");  // Log to verify the click event
    openUploadModal();
});



async function loadGroups() {
    console.log("Trying to fetch groups...");
    try {
        const response = await fetch('/group/all');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const groups = await response.json();
        console.log("Groups fetched:", groups);
        populateGroups(groups);
    } catch (error) {
        console.error('Error fetching groups:', error);
        document.getElementById('groupContainer').innerHTML = '<p>Error loading groups.</p>';
    }
}

function populateGroups(groups) {
    const groupContainer = document.getElementById('groupContainer');
    groupContainer.innerHTML = ''; // Clear previous content

    groups.forEach(group => {
        const div = document.createElement('div');
        div.innerHTML = `
            <input type="checkbox" name="group" id="group_${group.id}" value="${group.name}" />
            <label for="group_${group.id}">${group.name}</label>
        `;
        groupContainer.appendChild(div);
    });
}

document.getElementById('uploadForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    const formData = new FormData(this); // Get form data

    // Collect selected groups
    const selectedGroups = [];
    const groupCheckboxes = document.querySelectorAll('input[name="group"]:checked');
    groupCheckboxes.forEach(checkbox => {
        selectedGroups.push(checkbox.value);
    });

    formData.append('groups', JSON.stringify(selectedGroups)); // Append selected groups to FormData

    fetch('/upload', {
        method: 'POST',
        body: formData,
    })
    .then(response => {
        if (response.ok) {
            alert("File uploaded successfully!");
            closeUploadModal(); // Close the modal after successful upload
        } else {
            alert("Upload failed. Please try again.");
        }
    })
    .catch(error => console.error('Error during file upload:', error));
});

function openUploadModal() {
    console.log("Upload modal button clicked");
    loadGroups(); // Load groups when the modal is opened
    document.getElementById('uploadModal').style.display = 'block';
}

function closeUploadModal() {
    document.getElementById('uploadModal').style.display = 'none';
}

function uploadMaterial() {

        console.log("Sending Data");
        const formElement = document.getElementById('uploadForm');

        // Collect selected groups
        const selectedGroups = [];
        const groupCheckboxes = document.querySelectorAll('input[name="group"]:checked');
        groupCheckboxes.forEach(checkbox => {
            selectedGroups.push(checkbox.value);
        });

        formData.append('groups', JSON.stringify(selectedGroups)); // Append selected groups to FormData

        const fileInput = document.getElementById('file');
        const fileLinkInput = document.getElementById('fileLink');

        // Check if a file was selected
        if (fileInput.files.length > 0) {
            formData.append('file', fileInput.files[0]);
            formData.delete('fileLink'); // Remove the fileLink if a file is provided
        } else if (fileLinkInput.value.trim() !== '') {
            formData.append('fileLink', fileLinkInput.value.trim());
            formData.delete('file'); // Remove the file from FormData if no file is provided
        } else {
            alert("Please provide either a file or a file link.");
            return; // Stop the submission if neither file nor link is provided
        }

        // Add other necessary form fields
        formData.append('fileName', document.getElementById('fileName').value);
        formData.append('description', document.getElementById('description').value);

        // Perform the upload via fetch
        fetch('/material/upload-material', {
            method: 'POST',
            body: formData,
        })
        .then(response => {
            if (response.ok) {
                alert("File uploaded successfully!");
                closeUploadModal(); // Close the modal after successful upload
            } else {
                alert("Upload failed. Please try again.");
            }
        })
        .catch(error => console.error('Error during file upload:', error));
};