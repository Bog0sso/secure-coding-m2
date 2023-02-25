import React from "react";
import { useState } from "react";
import { NavLink } from "react-router-dom";
import { Navbar, Nav, Button } from "react-bootstrap";
import { CiLogout, CiEdit } from "react-icons/ci";
import { VscAccount } from "react-icons/vsc";
import {
  Dropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
} from "reactstrap";

const CliNavbar = () => {
  const [dropdownOpen, setDropdownOpen] = useState(false);

  const toggle = () => setDropdownOpen((prevState) => !prevState);
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
        <div>
          <Dropdown isOpen={dropdownOpen} toggle={toggle}>
            <DropdownToggle caret color="none" className="text-white">
              <VscAccount />
            </DropdownToggle>
            <DropdownMenu>
              <DropdownItem header>Zaid Kane</DropdownItem>
              <DropdownItem>Some Action</DropdownItem>
              <DropdownItem text>Dropdown Item Text</DropdownItem>
              <DropdownItem divider />
              <DropdownItem text>
                Editer
                <CiEdit />
              </DropdownItem>
              <DropdownItem>
                Log out <CiLogout />
              </DropdownItem>
            </DropdownMenu>
          </Dropdown>
        </div>
      </Navbar>
    </div>
  );
};

export default CliNavbar;
