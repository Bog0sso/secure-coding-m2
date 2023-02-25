import React from "react";
import { useState } from "react";
import { Outlet } from "react-router-dom";
import AddAccountForm from "../../Components/Forms/AddAccountForm";
import { BsPlus } from "react-icons/bs";

const AccountsPage = () => {
  const [createAccountmodalShow, setcreateAccountModalShow] = useState(false);
  return (
    <div>
      <h1>Account Page</h1>
      <div className="logo-circle2 icon icon-shape icon-lg bg-gradient-primary shadow text-center border-radius-lg">
        <span
          className="text-white"
          onClick={() => setcreateAccountModalShow(true)}
        >
          <i className="opacity-10">
            <BsPlus />
          </i>
        </span>
      </div>
      <AddAccountForm
        show={createAccountmodalShow}
        onHide={() => setcreateAccountModalShow(false)}
      />
    </div>
  );
};

export default AccountsPage;
