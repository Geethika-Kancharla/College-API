const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080';

const onSubmit = async (data) => {
    try {
        const response = await fetch(`${API_URL}/api/create`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(data)
        });

        const contentType = response.headers.get("content-type");
        if (!contentType || !contentType.includes("application/json")) {
            throw new TypeError("Oops, we haven't got JSON!");
        }

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.error || `HTTP error! status: ${response.status}`);
        }

        const result = await response.json();
        console.log('Success:', result);
        // Add success handling here (e.g., show success message, redirect, etc.)
    } catch (error) {
        console.error('Error during registration:', error);
        // Add error handling here (e.g., show error message to user)
    }
}; 