import React from "react";
import CliNavbar from "../../Components/Navbars/CliNavbar";
import { Outlet } from "react-router-dom";
import {
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  Navbar,
  Row,
} from "reactstrap";
import { BsEyeSlash, BsEye, BsThreeDots, BsPlus } from "react-icons/bs";

import { useState } from "react";
import TransactionForm from "../../Components/Forms/TransactionForm";
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
const ClientPage = ({ isAuthenticated }) => {
  const [modalShow, setModalShow] = useState(false);
  const [show, setShowAmount] = useState(false);
  // const {path}= useRoutes();
  // console.log(path+" tire girl")
  function showAmount() {
    setShowAmount(!show);
    console.log(show);
  }
  return (
    <div>
      <CliNavbar />
      <Container fluid>
        <Row>
          <Col xs="4"></Col>
          <Col xs="6">
            <Row>
              <Col xs="4">
                <Card className="cardColor">
                  <CardHeader className="card-header mx-4 p-3 text-center">
                    <div className="logo-circle2 icon icon-shape icon-lg bg-gradient-primary shadow text-center border-radius-lg">
                      <span className="text-xs text-white">
                        <i onClick={showAmount}>
                          {show ? <BsEye /> : <BsEyeSlash />}
                        </i>
                      </span>
                    </div>
                  </CardHeader>
                  <CardBody className="card-body pt-0 p-3 text-center">
                    <h6 className="text-center mb-0">Solde 💸</h6>

                    <hr className="horizontal dark my-3" />
                    <h5 className="mb-0 ">
                      {show ? (
                        456200000 + "francs"
                      ) : (
                        <div className="appColor">
                          <BsThreeDots /> <BsThreeDots />
                        </div>
                      )}
                    </h5>
                  </CardBody>
                </Card>
              </Col>
              <Col xs="6">
                <Card className="cardColor">
                  <CardHeader className="card-header mx-4 p-3 text-center">
                    <div className="logo-circle2 icon icon-shape icon-lg bg-gradient-primary shadow text-center border-radius-lg">
                      <span
                        className="text-white"
                        onClick={() => setModalShow(true)}
                      >
                        <i className="opacity-10">
                          <BsPlus />
                        </i>
                      </span>
                    </div>
                  </CardHeader>
                  <CardBody className="card-body pt-0 p-3 text-center">
                    <h6 className="text-center mb-0">Transaction</h6>
                    <hr className="horizontal dark my-3" />
                    <span className="text-xs">Effectuer une transaction</span>
                  </CardBody>
                </Card>
              </Col>
            </Row>
          </Col>
          <Col xs="4"></Col>
        </Row>{" "}
        <Outlet />
      </Container>
      {/* <Routes>
       
           {!isAuthenticated ?  <h1>HELLO YOU haven't login yet</h1>:<Route><Outlet/></Route>} 
            <Route path="/transactions" element={<TransactionPage />} />
          <Route path="/accounts" element={<AccountsPage />} />
          <Route path="/users" element={<UsersPage />} /> 
             <Route path={`${path}/transactions`} element={<TransactionPage />} />
            <Route path="accounts" element={<AccountsPage />} />
            <Route path="users" element={<UsersPage />} />
       
      </Routes> */}
      <TransactionForm show={modalShow} onHide={() => setModalShow(false)} />
    </div>
  );
};

export default ClientPage;
