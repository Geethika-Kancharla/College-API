const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080';

const fetchColleges = async () => {
    try {
        const response = await fetch(`${API_URL}/api/details`, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            credentials: 'include'
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        setColleges(data);
    } catch (error) {
        console.error('Error fetching colleges:', error);
        // Add error handling here (e.g., show error message to user)
    }
}; 