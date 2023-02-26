import React from "react";
import { NavLink } from "react-router-dom";
import {
  UncontrolledCollapse,
  Navbar,
  Nav,
  NavDropdown,
  Form,
  FormControl,
  Button,
} from "react-bootstrap";
const Navigation = ({ profil }) => {
  return (
    profil === "admin" && (
      <Navbar bg="light" expand="lg">
        <Navbar.Brand href="#home">
          e-k
          {/* <Image src={logo} alt="e-knox logo" style={{ height: "40px" }} /> */}
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="#home">Dashboard</Nav.Link>
            <Nav.Link href="#users">Users</Nav.Link>
            <Nav.Link href="#accounts">Accounts</Nav.Link>
            <Nav.Link href="#transactions">Transactions</Nav.Link>

          </Nav>
          <Nav className="ml-auto">
            <Button variant="danger">Logout</Button>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    )
  );
};

export default Navigation;
