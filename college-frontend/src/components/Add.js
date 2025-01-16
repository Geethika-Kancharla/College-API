const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080';

const onSubmit = async (data) => {
    try {
        const response = await fetch(`${API_URL}/api/colleges/create`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            const errorText = await response.text();
            console.error('Response status:', response.status);
            console.error('Response body:', errorText);
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const result = await response.json();
        
        console.log('Success:', result);
    } catch (error) {
        console.error('Error during registration:', error);
    }
}; 