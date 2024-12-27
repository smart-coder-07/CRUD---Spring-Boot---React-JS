import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate, redirect } from "react-router-dom";

const Read = () => {
  const [id, setId] = useState("");
  const [data, setData] = useState(null);
  const [error, setError] = useState(false);
  const navigate = useNavigate();

  const submitHandler = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.get(`http://localhost:8000/crud/read/${id}`);
      setData(res.data);
      console.log(res.data);
    } catch (err) {
      setError(true);
      alert(err.response.data);
      window.location.reload("/read");
      console.error(err.res.data);
    }
  };

  return (
    <div className="card bordered shadow-lg max-w-xl mx-auto mt-10 p-5">
      <h2 className="text-xl font-semibold text-center mb-3">Read Data</h2>
      <form onSubmit={submitHandler}>
        <input
          type="text"
          placeholder="Type ID"
          className="input input-bordered input-success w-full"
          value={id}
          onChange={(e) => setId(e.target.value)}
        />
        <button className="btn btn-primary mt-2">Show Data</button>
      </form>
      {/* {error && <p className="text-center mt-5">No data to show</p>} */}
      {data && (
        <div className="overflow-x-auto w-full mt-5">
          <table className="table w-full">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{data.id}</td>
                <td>{data.name}</td>
                <td>{data.email}</td>
                <td>{data.address}</td>
              </tr>
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default Read;
