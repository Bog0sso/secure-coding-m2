import React from "react";
import { NavLink } from "react-router-dom";
import { Navbar, Nav, Button } from "react-bootstrap";
import { CiLogout } from "react-icons/ci";
import { VscAccount } from "react-icons/vsc";

const CliNavbar = () => {
  return (
    <div className="ground">
      <Navbar
        // expand="lg"
        className="navbar-main navbar px-0 mx-4 shadow-none   mt-3 mx-3"
      >
        <Navbar.Brand href="#home" className="logo-text logo-circle">
          e-<span className="text-white">KNOX</span>
        </Navbar.Brand>

        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto nav">
            <Nav.Link href="/client">Home</Nav.Link>
            <Nav.Link href="/client/transactions">Transactions</Nav.Link>
          </Nav>
        </Navbar.Collapse>

        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <div className="text-white">
          <pre>
            <VscAccount /> | <CiLogout />
          </pre>
        </div>
      </Navbar>
    </div>
  );
};

export default CliNavbar;
