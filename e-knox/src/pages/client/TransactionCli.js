import React from "react";
import {
  BrowserRouter,
  Routes,
  Route,
  Outlet,
  useRoutes,
} from "react-router-dom";
import {
  Card,
  CardBody,
  CardHeader,
  CardTitle,
  Col,
  Container,
  Row,
} from "reactstrap";
import { BiTransfer } from "react-icons/bi";
const TransactionCli = ({ isAuthenticated }) => {
  const today = new Date();
  const date = today.toLocaleDateString();
  // console.log(path+" tire girl")
  return (
    <Container className="py-4" fluid>
      <Row>
        <Col md="2" className="mt-4"></Col>
        <Col md="8" className="mt-4">
          <Card className="card h-100 mb-4">
            <CardHeader className="card-header card-header-tabs card-header-primary pb-0 px-3">
              <Row>
                <Col md="6">
                  <CardTitle>
                    <pre>
                      <h6 className="mb-0 card-title">
                        Historique des transactions{" "}
                        <BiTransfer className="appIcon" />
                      </h6>
                    </pre>
                  </CardTitle>
                </Col>
                <div className="col-md-6 d-flex justify-content-end align-items-center">
                  <i className="far fa-calendar-alt me-2"></i>
                  <small>{date}</small>
                </div>
              </Row>
            </CardHeader>
            <CardBody className="card-body pt-4 p-3">
              <ul className="list-group">
                <li className="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                  <div className="d-flex align-items-center">
                    <button className="btn btn-icon-only btn-rounded btn-outline-danger mb-0 me-3 btn-sm d-flex align-items-center justify-content-center">
                      <i className="fas fa-arrow-down"></i>
                    </button>
                    <div className="d-flex flex-column">
                      <h6 className="mb-1 text-dark text-sm">Netflix</h6>
                      <span className="text-md">
                        27 March 2020, at 12:30 PM
                      </span>
                    </div>
                  </div>
                  <div className="d-flex align-items-center text-danger text-gradient text-sm font-weight-bold">
                    - $ 2,500
                  </div>
                </li>
                <li className="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                  <div className="d-flex align-items-center">
                    <button className="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-3 btn-sm d-flex align-items-center justify-content-center">
                      <i className="fas fa-arrow-up"></i>
                    </button>
                    <div className="d-flex flex-column">
                      <h6 className="mb-1 text-dark text-sm">Apple</h6>
                      <span className="text-md">
                        27 March 2020, at 04:30 AM
                      </span>
                    </div>
                  </div>
                  <div className="d-flex align-items-center text-success text-gradient text-sm font-weight-bold">
                    + $ 2,000
                  </div>
                </li>
              </ul>
              <ul className="list-group">
                <li className="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                  <div className="d-flex align-items-center">
                    <button className="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-3 btn-sm d-flex align-items-center justify-content-center">
                      <i className="fas fa-arrow-up"></i>
                    </button>
                    <div className="d-flex flex-column">
                      <h6 className="mb-1 text-dark text-sm">Stripe</h6>
                      <span className="text-md">
                        26 March 2020, at 13:45 PM
                      </span>
                    </div>
                  </div>
                  <div className="d-flex align-items-center text-success text-gradient text-sm font-weight-bold">
                    + $ 750
                  </div>
                </li>
                <li className="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                  <div className="d-flex align-items-center">
                    <button className="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-3 btn-sm d-flex align-items-center justify-content-center">
                      <i className="fas fa-arrow-up"></i>
                    </button>
                    <div className="d-flex flex-column">
                      <h6 className="mb-1 text-dark text-sm">HubSpot</h6>
                      <span className="text-md">
                        26 March 2020, at 12:30 PM
                      </span>
                    </div>
                  </div>
                  <div className="d-flex align-items-center text-success text-gradient text-sm font-weight-bold">
                    + $ 1,000
                  </div>
                </li>
                <li className="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                  <div className="d-flex align-items-center">
                    <button className="btn btn-icon-only btn-rounded btn-outline-success mb-0 me-3 btn-sm d-flex align-items-center justify-content-center">
                      <i className="fas fa-arrow-up"></i>
                    </button>
                    <div className="d-flex flex-column">
                      <h6 className="mb-1 text-dark text-sm">Creative Tim</h6>
                      <span className="text-md">
                        26 March 2020, at 08:30 AM
                      </span>
                    </div>
                  </div>
                  <div className="d-flex align-items-center text-success text-gradient text-sm font-weight-bold">
                    + $ 2,500
                  </div>
                </li>
                <li className="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                  <div className="d-flex align-items-center">
                    <button className="btn btn-icon-only btn-rounded btn-outline-dark mb-0 me-3 btn-sm d-flex align-items-center justify-content-center">
                      <i className="fas fa-exclamation"></i>
                    </button>
                    <div className="d-flex flex-column">
                      <h6 className="mb-1 text-dark text-sm">Webflow</h6>
                      <span className="text-md">
                        26 March 2020, at 05:00 AM
                      </span>
                    </div>
                  </div>
                  <div className="d-flex align-items-center text-dark text-sm font-weight-bold">
                    Pending
                  </div>
                </li>
              </ul>
            </CardBody>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default TransactionCli;
