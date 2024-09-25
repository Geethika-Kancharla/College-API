import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

const Add = () => {
    const [formData, setFormData] = useState({
        collegeName: '',
        courseName: '',
        courseFees: '',
        durationOfCourse: '',
        accommodation: '',
        accommodationFee: ''
    });

    const navigate = useNavigate();
    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            // Log full response for debugging
            const responseBody = await response.text(); // Using `text()` to handle any unexpected non-JSON response
            console.log('Response status:', response.status);
            console.log('Response body:', responseBody);

            if (response.ok) {
                navigate("/");
            } else {
                const data = JSON.parse(responseBody); // Handle case if it's JSON, but not ok
                setMessage(data.message || 'Registration failed. Please try again.');
            }
        } catch (error) {
            setMessage('Registration failed. Please try again.');
            console.error('Error during registration:', error);
        }
    };


    return (
        <div className="flex justify-center items-center min-h-screen bg-red-50 p-4">
            <div className="w-full max-w-5xl bg-white p-6 md:p-8 rounded-lg shadow-md border border-red-200">
                <h2 className="text-xl md:text-2xl font-bold mb-6 text-center text-red-500">Add a College</h2>
                <form onSubmit={handleSubmit}>
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
                        <div className="mb-4">
                            <label className="block text-gray-700 mb-1">College Name:</label>
                            <input
                                type="text"
                                name="collegeName"
                                placeholder="Enter your full name"
                                value={formData.collegeName}
                                onChange={handleChange}
                                className="w-full px-3 py-2 border-b-2 border-gray-300 focus:outline-none  focus:bg-gray-100"
                                required
                            />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 mb-1">Course Name:</label>
                            <input
                                type="text"
                                name="courseName"
                                placeholder="Enter your Course Name"
                                value={formData.courseName}
                                onChange={handleChange}
                                className="w-full px-3 py-2 border-b-2 border-gray-300 focus:outline-none focus:bg-gray-100"
                                required
                            />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 mb-1">Course Fees:</label>
                            <input
                                type="text"
                                name="courseFees"
                                placeholder="Enter your Course Fees"
                                value={formData.courseFees}
                                onChange={handleChange}
                                className="w-full px-3 py-2 border-b-2 border-gray-300 focus:outline-none  focus:bg-gray-100"
                                required
                            />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 mb-1">Duration Of Course:</label>
                            <input
                                type="text"
                                name="durationOfCourse"
                                placeholder="Enter your Duration Of Course"
                                value={formData.durationOfCourse}
                                onChange={handleChange}
                                className="w-full px-3 py-2 border-b-2 border-gray-300 focus:outline-none  focus:bg-gray-100"
                                required
                            />
                        </div>
                        <div className="mb-4">
                            <label className="block text-gray-700 mb-1">Accommodation:</label>
                            <input
                                type="text"
                                name="accommodation" // Fixed field name here
                                placeholder="Enter your Accommodation type"
                                value={formData.accommodation}
                                onChange={handleChange}
                                className="w-full px-3 py-2 border-b-2 border-gray-300 focus:outline-none focus:bg-gray-100"
                                required
                            />
                        </div>

                        <div className="mb-4">
                            <label className="block text-gray-700 mb-1">Accommodation Fee:</label>
                            <input
                                type="text"
                                name="accommodationFee"
                                placeholder="Enter your Accommodation Fee"
                                value={formData.accommodationFee}
                                onChange={handleChange}
                                className="w-full px-3 py-2 border-b-2 border-gray-300 focus:outline-none focus:bg-gray-100"
                                required
                            />
                        </div>
                    </div>
                    <button
                        type="submit"
                        className="w-fit text-center bg-red-500 text-white py-3 px-4 rounded-md hover:bg-red-600 transition duration-200"
                    >
                        Add
                    </button>
                </form>
                <div className="mt-6 text-center">
                    <p className="text-gray-600">
                        <Link to="/" className="text-red-500 hover:underline">Back to Home page</Link>
                    </p>
                </div>
                {message && (
                    <div className="mt-4 text-center text-red-500">
                        {message}
                    </div>
                )}
            </div>
        </div>
    );
};

export default Add;