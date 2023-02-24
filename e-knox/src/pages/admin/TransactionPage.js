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
import TransactionForm from "../../Components/Forms/TransactionForm";
import { transactionList } from "../../datas/transactionList";
import { BsThreeDots } from "react-icons/bs";
import { MdOutlineCancel } from "react-icons/md";
import { RxCheckCircled } from "react-icons/rx";

const TransactionPage = () => {
  function showTransactionDetails(id) {}
  return (
    <div>
      <Container>
        <Row className="justify-content-center">
          <Col lg="8" className=" mx-auto">
            <Card className="z-index-0">
              <CardHeader className="card-header card-header-tabs card-header-primary">
                <CardTitle className="card-title ">Transactions</CardTitle>
              </CardHeader>
              <div className="card-header pb-0">
                <h6>Gerer les Transactions</h6>
              </div>
              <CardBody className="card-body   table-responsive p-0">
                <div>
                  <ul className="list-group">
                    {transactionList.map((trans) => (
                      <li
                        key={trans.transaction_ID}
                        className="box list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg"
                      >
                        <div className="d-flex align-items-center">
                          <button className="btn btn-icon-only btn-rounded btn-outline-danger mb-0 me-3 btn-sm d-flex align-items-center justify-content-center">
                            <i className="fas fa-arrow-down"></i>
                          </button>
                          <div className="d-flex flex-column">
                            <h6 className="mb-1 text-dark text-sm">
                              De {trans.numOrigine} à {trans.numDestinataire}
                            </h6>
                            <span className="">
                              Date:{trans.dateTransaction}
                            </span>
                            <span>ID:{trans.transaction_ID}</span>
                            <span>
                              Montant:<b>{trans.montantTransaction}</b>
                            </span>
                            <span>Type: {trans.typeTransaction}</span>
                          </div>
                        </div>
                        {/* {trans.transaction_ID}




                        {trans.typeTransaction} */}
                        <div className="d-flex align-items-center text-danger text-gradient text-sm font-weight-bold">
                          <Badge
                            color={`${
                              trans.statutTransaction === "attente"
                                ? "primary"
                                : trans.statutTransaction === "SUCCES"
                                ? "success"
                                : "warning"
                            }`}
                            className="text-white"
                            pill
                          >
                            {trans.statutTransaction}
                          </Badge>
                        </div>
                        <div className="logo-circle2">
                          <BsThreeDots
                            className="text-white"
                            onClick={showTransactionDetails(
                              trans.transaction_ID
                            )}
                          />
                        </div>
                      </li>
                    ))}
                  </ul>
                </div>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default TransactionPage;
