import React from "react";
import { useState } from "react";
import { Navbar, Nav, Button } from "react-bootstrap";
import { CiLogin } from "react-icons/ci";
import LoginForm from "../Forms/LoginForm";
const HomeNavbar = () => {
  const [modalShow, setModalShow] = useState(false);
  return (
    <Navbar
      expand="lg"
      className="navbar-main navbar-expand-lg px-0 mx-4 shadow-none   mt-3 mx-3"
    >
      <Navbar.Brand href="#home" className="logo-text logo-circle">
        e-<span className="text-white">KNOX</span>
      </Navbar.Brand>

      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto nav ">
          <Nav.Link href="#" className="text-white">
            Home
          </Nav.Link>
          <Nav.Link href="#" className="text-white">
            About
          </Nav.Link>
          <Nav.Link href="#" className="text-white">
            Contact
          </Nav.Link>
        </Nav>
      </Navbar.Collapse>

      <Navbar.Toggle aria-controls="basic-navbar-nav" />

      <div className="text-white" onClick={() => setModalShow(true)}>
        Connexion
        <CiLogin />
      </div>
      <LoginForm show={modalShow} onHide={() => setModalShow(false)} />
    </Navbar>
  );
};

export default HomeNavbar;
