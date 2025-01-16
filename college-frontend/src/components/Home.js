const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080';


const fetchColleges = async () => {
    try {
        const response = await fetch(`${API_URL}/api/colleges/details`);
        if (!response.ok) {
            const errorText = await response.text();
            console.error('Response status:', response.status);
            console.error('Response body:', errorText);
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        setColleges(data);
    } catch (error) {
        console.error('Error fetching colleges:', error);
    }
}; 