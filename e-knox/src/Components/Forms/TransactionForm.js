import React, { useState } from "react";
import { useForm } from "react-hook-form";
// import axios from "axios";
import { Modal } from "react-bootstrap";
const TransactionForm = (props) => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const [isSubmitting, setIsSubmitting] = useState(false);
  const ONLY_LETTERS = "Ce champs ne doit contenir que des lettres";
  const submitAction = (data) => {
    setIsSubmitting(true);

    console.log(data);
  };

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
              <h4>Effectuer une nouvelle Transaction</h4>
            </Modal.Title>
          </Modal.Header>
          <Modal.Body className="card-body">
            <form onSubmit={handleSubmit(submitAction)}>
              <div className="form-group">
                <label>Nom Destinataire</label>
                <input
                  className={`form-control ${
                    errors.nomDest ? "is-invalid" : ""
                  }`}
                  type="text"
                  name="nomDest"
                  {...register("nomDest", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.nomDest && (
                  <span className="text text-danger">{ONLY_LETTERS}</span>
                )}
              </div>
              <br />

              <div className="form-group">
                <label>Prenom Destinataire:</label>
                <input
                  className={`form-control ${
                    errors.prenomDest ? "is-invalid" : ""
                  }`}
                  type="text"
                  name="prenomDest"
                  {...register("prenomDest", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.prenomDest && (
                  <span className="text text-danger">{ONLY_LETTERS}</span>
                )}
              </div>
              <br />

              <div className="form-group">
                <label>Numero Destinataire:</label>
                <input
                  className={`form-control ${
                    errors.numDest ? "is-invalid" : ""
                  }`}
                  type="number"
                  name="numDest"
                  {...register("numDest", {
                    required: true,
                    pattern: /^[0-9]+$/,
                    min: 1,
                  })}
                />
                {errors.numDest && (
                  <span className="text text-danger">
                    Ce champs ne doit contenir que des chiffres
                  </span>
                )}
              </div>
              <br />

              <div className="form-group">
                <label>Montant</label>
                <input
                  className={`form-control ${
                    errors.montant ? "is-invalid" : ""
                  }`}
                  type="text"
                  name="montant"
                  {...register("montant", {
                    required: true,
                    pattern: /^[0-9]+$/,
                  })}
                />
                {errors.montant && (
                  <span className="text text-danger">Montant invalide</span>
                )}
              </div>
              <br />

              <button
                type="submit"
                disabled={isSubmitting}
                className="btn btn-primary"
              >
                Soummettre
              </button>
            </form>
          </Modal.Body>
          {/* </div> */}
        </div>
      </div>
    </Modal>
  );
};

export default TransactionForm;
