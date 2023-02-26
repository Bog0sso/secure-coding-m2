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
const AdminNavbar = () => {
  const [dropdownOpen, setDropdownOpen] = useState(false);

  const toggle = () => setDropdownOpen((prevState) => !prevState);
  return (
    <div>
      <Navbar
        expand="lg"
        className="navbar-main navbar-expand-lg px-0 mx-4 shadow-none   mt-3 mx-3"
      >
        <Navbar.Brand href="#home" className="logo-text logo-circle">
          e-<span className="text-white">KNOX</span>
        </Navbar.Brand>

        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto nav ">
            <Nav.Link href="/admin/" className="text-white">
              Home
            </Nav.Link>
            <Nav.Link href="/admin/users" className="text-white">
              Utilisateurs
            </Nav.Link>
            <Nav.Link href="/admin/accounts" className="text-white">
              Comptes
            </Nav.Link>
            <Nav.Link href="/admin/transactions" className="text-white">
              Transactions
            </Nav.Link>
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
      {/* <div className="space">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quam, consequuntur optio labore perspiciatis libero ullam fuga blanditiis, quidem est illum quis dolor, cum aut laborum eum accusamus magni quia sunt.</div> */}
    </div>
  );
};

export default AdminNavbar;
