import React from "react";
import AdminNavbar from "../../Components/Navbars/AdminNavbar";
import { Outlet } from "react-router-dom";
const AdminPage = () => {
  return (
    <div>
      <AdminNavbar />
      <Outlet />
    </div>
  );
};

export default AdminPage;
