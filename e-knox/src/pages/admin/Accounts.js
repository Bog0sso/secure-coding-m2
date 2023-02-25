import React from "react";
import { Outlet } from "react-router-dom";
import AddAccountForm from "../../Components/Forms/AddAccountForm";

const AccountsPage = () => {
  return (
    <div>
      <h1>Account Page</h1>
      <AddAccountForm />
    </div>
  );
};

export default AccountsPage;
