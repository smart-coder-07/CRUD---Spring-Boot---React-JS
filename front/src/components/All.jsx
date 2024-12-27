import axios, { all } from "axios";
import React, { useEffect, useState } from "react";
import { use } from "react";

const All = () => {
  const [data, setData] = useState([]);
  const allData = async () => {
    try {
      const res = await axios.get("http://localhost:8000/crud/readAll");
      setData(res.data);
      console.log(res.data);
    } catch (err) {
      console.error(err.message);
    }
  };

  useEffect(() => {
    allData();
  }, []);

  return (
    <div className="card bordered shadow-lg max-w-xl mx-auto mt-10 p-5">
      <h2 className="text-xl font-semibold text-center mb-3">All Data</h2>
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
            {data.map((e) => (
              <tr key={e.id}>
                <td>{e.id}</td>
                <td>{e.name}</td>
                <td>{e.email}</td>
                <td>{e.address}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default All;
