import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { Modal } from "react-bootstrap";

const CreateUserForm = (props) => {
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
              <h4>Creation d'un utilisateur</h4>
            </Modal.Title>
          </Modal.Header>
          <Modal.Body className="card-body">
            <form onSubmit={handleSubmit(submitAction)}>
              <div className="form-group">
                <label>Nom</label>
                <input
                  className={`form-control ${
                    errors.nomDest ? "invalid" : "valid"
                  }`}
                  type="text"
                  name="nomDest"
                  {...register("nomDest", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.nomDest && (
                  <span className="text text-danger">
                    Ce champs ne doit contenir que des lettres
                  </span>
                )}
              </div>
              <div className="form-group">
                <label>Prenom : </label>
                <input
                  className="form-control"
                  type="text"
                  name="prenomDest"
                  {...register("prenomDest", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.prenomDest && (
                  <span className="text text-danger">
                    Ce champs ne doit contenir que des lettres
                  </span>
                )}
              </div>
              <div className="form-group">
                <label>Date de naissamce:</label>
                <input
                  className="form-control"
                  type="date"
                  name="dateN"
                  {...register("dateN", {
                    required: true,
                  })}
                />
                {errors.dateN && (
                  <span className="text text-danger">Date invalide</span>
                )}
              </div>

              <div className="form-group">
                <label>Lieu de naissance</label>
                <input
                  className="form-control"
                  type="text"
                  name="lieuN"
                  {...register("lieuN", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.lieuN && (
                  <span className="text text-danger">Saisie invalide</span>
                )}
              </div>
              <div className="form-group">
                <label>Adresse</label>
                <input
                  className="form-control"
                  type="text"
                  name="adresse"
                  {...register("adresse", {
                    required: true,
                    pattern: /^[a-zA-Z-0-9]+$/,
                  })}
                />
                {errors.adresse && (
                  <span className="text text-danger">Adresse invalide</span>
                )}
              </div>
              <div className="form-group">
                <label>Telephone</label>
                <input
                  className="form-control"
                  type="number"
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

              <div className="form-group">
                <label>Email</label>
                <input
                  className="form-control"
                  type="email"
                  name="email"
                  {...register("email", {
                    required: true,
                    pattern: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
                  })}
                />
                {errors.email && (
                  <span className="text text-danger">Email invalide</span>
                )}
              </div>

              <button
                type="submit"
                disabled={isSubmitting}
                className="btn btn-primary"
              >
                Submit
              </button>
            </form>
          </Modal.Body>
          {/* </div> */}
        </div>
      </div>
    </Modal>
  );
};

export default CreateUserForm;
