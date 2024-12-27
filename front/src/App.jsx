import React from "react";
import Main from "./components/Main";
import Layout from "./components/Layout";
import { Routes, Route } from "react-router-dom";
import Create from "./components/Create";
import Update from "./components/Update";
import Read from "./components/Read";
import Delete from "./components/Delete";
import All from "./components/All";

const App = () => {
  return (
    <>
      <Layout>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/create" element={<Create />} />
          <Route path="/read" element={<Read />} />
          <Route path="/update" element={<Update />} />
          <Route path="/delete" element={<Delete />} />
          <Route path="/all" element={<All />} />
        </Routes>
      </Layout>
    </>
  );
};

export default App;
