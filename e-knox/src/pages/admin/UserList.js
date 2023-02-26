import React, { useState } from "react";
// import {input} from "react-strap"
import {
  Form,
  FormGroup,
  label,
  input,
  Table,
  Button,
  inputGroup,
} from "react-bootstrap";
import { Outlet } from "react-router-dom";
import {
  Badge,
  Container,
  Card,
  CardBody,
  CardHeader,
  CardTitle,
  Col,
  Row,
} from "reactstrap";
import { transactionList } from "../../datas/transactionList";
import { BsThreeDots } from "react-icons/bs";
import { MdOutlineCancel } from "react-icons/md";
import { RxCheckCircled } from "react-icons/rx";

const UserList = () => {
  function showTransactionDetails(id) {}
  return (
    <div>
      <Container>
        <Row className="justify-content-center">
          <Col lg="10" className=" mx-auto">
            <Card className=" card z-index-0">
              <CardHeader className="card-header card-header-tabs card-header-primary">
                <CardTitle className="card-title ">
                  Liste utilisateurs
                </CardTitle>
              </CardHeader>
              <div className="card-header pb-0">
                <h6>Gerer les utilisateurs</h6>
              </div>
              <CardBody className="card-body">
                <Table
                  className=" table table-hover table align-items-center "
                  hover
                >
                  <thead>
                    <tr>
                      <th>
                        <b>#</b>
                      </th>
                      <th>
                        <b>Nom</b>
                      </th>
                      <th>
                        <b>Prenom</b>
                      </th>
                      <th>
                        <b>Type</b>
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    {transactionList.map((trans) => (
                      <tr key={trans.transaction_ID}>
                        <td>{trans.dateTransaction}</td>
                        <td>{trans.dateTransaction}</td>
                        <td>{trans.dateTransaction}</td>
                        <td>Montant:{trans.montantTransaction}</td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default UserList;
