import React, { useState } from "react";
import axios from "axios";

const Delete = () => {
  const [id, setId] = useState("");
  const [data, setData] = useState(null);

  const clickHandler = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.delete(`http://localhost:8000/crud/delete/${id}`);
      setData(res.data);
      console.log(res.data);
    } catch (err) {
      alert(err.response.data);
      console.error(err.response.data);
    }
  };

  return (
    <div className="card bordered shadow-lg max-w-xl mx-auto mt-10 p-5">
      <h2 className="text-xl font-semibold text-center mb-3">Delete Data</h2>
      <input
        type="text"
        placeholder="Type ID"
        className="input input-bordered input-primary w-full mb-5"
        value={id}
        onChange={(e) => setId(e.target.value)}
      />
      <button className="btn btn-error" onClick={clickHandler}>
        Delete
      </button>
      {data && (
        <div className="mt-5">
          <p className="text-center">{data}</p>
        </div>
      )}
    </div>
  );
};

export default Delete;
