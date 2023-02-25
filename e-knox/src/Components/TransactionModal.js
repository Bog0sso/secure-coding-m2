import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { transactionList } from "../datas/transactionList";
// import axios from "axios";
import { Modal } from "react-bootstrap";
const TransactionModal = (props) => {
  const transaction = transactionList.find(
    (trans) => trans.transaction_ID === props.selectedtransid
  );
  return (
    // <div>numDestinataire, Status status, double montant, Devise devise,</div>
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <div className="row mt-lg-n10 mt-md-n11 mt-n10 justify-content-center">
        <div className="col-xl-8 col-lg-8 col-md-7 mx-auto">
          {/* <div className=" card"> */}
          <Modal.Header
            className="modal-header card-header-tabs card-header-primary"
            closeButton
          >
            <Modal.Title className="card-title ">
              <h4>Details Transaction # {transaction.transaction_ID}</h4>
            </Modal.Title>
          </Modal.Header>
          <Modal.Body className="card-body">
            <p>
              <b>ID: </b>
              {transaction.transaction_ID}
            </p>
            <p>
              <b>Numero Origine: </b>
              {transaction.numOrigine}
            </p>
            <p>
              <b>Numero Destinataire: </b>
              {transaction.numDestinataire}
            </p>
            <p>
              <b>Montant :</b>
              {transaction.montantTransaction}
            </p>
            <p>
              <b>Date: </b>
              {transaction.dateTransaction}
            </p>
            <p>
              <b>Type: </b>
              {transaction.typeTransaction}
            </p>
            <p>
              <b>Statut: </b>
              {transaction.statutTransaction}
            </p>
          </Modal.Body>
          {/* </div> */}
        </div>
      </div>
    </Modal>
  );
};

export default TransactionModal;
