import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";

const Home = () => {


    const TABLE_HEAD = ["College Name", "Course Name", "Course Fee", "Duration of Course", "Accomodation(AC/Non-AC)", "Accomodation Fee"];

    const [users, setUsers] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [usersPerPage] = useState(3);

    const indexOfLastUser = currentPage * usersPerPage;
    const indexOfFirstUser = indexOfLastUser - usersPerPage;
    const currentUsers = users.slice(indexOfFirstUser, indexOfLastUser);

    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    const getAll = async () => {
        try {
            const response = await fetch("http://localhost:8080/details");

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const data = await response.json();

            setUsers(data);
            console.log(data);

        } catch (error) {
            console.error("Error fetching colleges:", error);
        }
    };


    useEffect(() => {
        getAll();
    }, []);


    return (
        <div className="h-full w-full p-6">
            <div className="mb-8 flex items-center justify-between gap-8">
                <div>
                    <h2 className="text-3xl font-semibold text-red-700">College Records</h2>
                    <p className="text-gray-500 mt-1 text-sm">See information about all colleges</p>
                </div>
                <div className="flex flex-col gap-2 sm:flex-row">

                    <button className="border border-gray-300 rounded px-4 py-2 text-sm text-gray-700 hover:bg-black hover:text-white" onClick={getAll}>
                        View all
                    </button>
                    <Link to="/add" ><button className="flex items-center gap-2 border border-gray-300 rounded px-4 py-2 text-sm text-gray-700 hover:bg-black hover:text-white">
                        Add college
                    </button></Link>
                </div>
            </div>

            <div className="mt-4 overflow-x-auto">
                <table className="w-full min-w-max table-auto text-left">
                    <thead>
                        <tr>
                            {TABLE_HEAD.map((head) => (
                                <th
                                    key={head}
                                    className="border-b border-gray-200 bg-gray-50 p-4 text-sm font-medium text-gray-600"
                                >
                                    {head}
                                </th>
                            ))}
                        </tr>
                    </thead>
                    <tbody>
                        {currentUsers.map((user, index) => (
                            <tr key={index}>
                                <td className="p-4 py-6 border-b border-gray-200">
                                    <p className="text-sm text-gray-500">{user.collegeName}</p>
                                </td>
                                <td className="p-4 pl-0 border-b border-gray-200">
                                    <p className="text-sm text-gray-500">{user.courseName}</p>
                                </td>
                                <td className="p-4 border-b border-gray-200">
                                    <p className="text-sm text-gray-500">{user.courseFees}</p>
                                </td>
                                <td className="p-4 pl-6 border-b border-gray-200">
                                    <p className="text-sm text-gray-500">{user.durationOfCourse}</p>
                                </td>
                                <td className="p-4 border-b border-gray-200">
                                    <p className="text-sm text-gray-500">{user.accommodation}</p>
                                </td>
                                <td className="p-4 pl-10 border-b border-gray-200">
                                    <p className="text-sm text-gray-500">{user.accommodationFee}</p>
                                </td>

                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <div className="flex items-center justify-between border-t border-gray-200 p-4">
                <p className="text-sm text-gray-600">Page {currentPage} of {Math.ceil(users.length / usersPerPage)}</p>
                <div className="flex gap-2">
                    <button
                        className="border border-gray-300 rounded px-4 py-2 text-sm text-gray-700 hover:bg-black hover:text-white"
                        onClick={() => paginate(currentPage - 1)}
                        disabled={currentPage === 1}
                    >
                        Previous
                    </button>
                    <button
                        className="border border-gray-300 rounded px-4 py-2 text-sm text-gray-700 hover:bg-black hover:text-white"
                        onClick={() => paginate(currentPage + 1)}
                        disabled={currentPage === Math.ceil(users.length / usersPerPage)}
                    >
                        Next
                    </button>
                </div>
            </div>
        </div>
    )
}

export default Home