import React from 'react';
import { Navbar, Nav, Button } from "react-bootstrap";
const HomeNavbar = () => {
    return (
      <Navbar
        expand="lg"
        className="navbar-main navbar-expand-lg px-0 mx-4 shadow-none   mt-3 mx-3"
      >
        <Navbar.Brand href="#home" className="logo-text">
          e-knox
        </Navbar.Brand>
        <Nav className="mr-auto" navbar>
          <Nav.Item>
            <Nav.Link href="#">Home</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="#">About</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="#">Contact</Nav.Link>
          </Nav.Item>
        </Nav>
      </Navbar>
    );
};

export default HomeNavbar;