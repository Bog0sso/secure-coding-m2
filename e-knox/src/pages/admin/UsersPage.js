import React from "react";
import { Outlet } from "react-router-dom";
import CreateUserForm from "../../Components/Forms/CreateUserForm.js";
import { BsPlus } from "react-icons/bs";
import { useState } from "react";
import UserList from "./UserList";
const UsersPage = () => {
  const [modalShow, setModalShow] = useState(false);
  return (
    <div>
      <div className="logo-circle2 icon icon-shape icon-lg bg-gradient-primary shadow text-center border-radius-lg">
        <span className="text-white" onClick={() => setModalShow(true)}>
          <i className="opacity-10">
            <BsPlus />
          </i>
        </span>
      </div>
      <CreateUserForm show={modalShow} onHide={() => setModalShow(false)} />
      <UserList />
    </div>
  );
};

export default UsersPage;
