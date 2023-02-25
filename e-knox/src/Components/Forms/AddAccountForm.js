import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { Form, FormGroup, Modal } from "react-bootstrap";
const AddAccountForm = (props) => {
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
              <h4>Creation Compte</h4>
            </Modal.Title>
          </Modal.Header>
          <Modal.Body className="card-body">
            <Form onSubmit={handleSubmit(submitAction)}>
              <FormGroup className="form-group">
                <label>Nom</label>
                <input
                  className={`form-control ${errors.nom ? "is-invalid" : ""}`}
                  type="text"
                  name="nom"
                  {...register("nom", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.nom && (
                  <span className="text text-danger">
                    Ce champs ne doit contenir que des lettres
                  </span>
                )}
              </FormGroup>
              <FormGroup className="form-group">
                <label>Prenom : </label>
                <input
                  className={`form-control ${
                    errors.prenom ? "is-invalid" : ""
                  }`}
                  type="text"
                  name="prenom"
                  {...register("prenom", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.prenom && (
                  <span className="text text-danger">
                    Ce champs ne doit contenir que des lettres
                  </span>
                )}
              </FormGroup>
              <FormGroup className="form-group">
                <label>Date de naissamce:</label>
                <input
                  className={`form-control ${errors.dateN ? "is-invalid" : ""}`}
                  type="date"
                  name="dateN"
                  {...register("dateN", {
                    required: true,
                  })}
                />
                {errors.dateN && (
                  <span className="text text-danger">Date invalide</span>
                )}
              </FormGroup>

              <FormGroup className="form-group">
                <label>Lieu de naissance</label>
                <input
                  className={`form-control ${errors.lieuN ? "is-invalid" : ""}`}
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
              </FormGroup>
              <FormGroup className="form-group">
                <label>Adresse</label>
                <input
                  className={`form-control ${
                    errors.adresse ? "is-invalid" : ""
                  }`}
                  type="text"
                  name="adresse"
                  {...register("adresse", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.adresse && (
                  <span className="text text-danger">Adresse invalide</span>
                )}
              </FormGroup>
              <FormGroup className="form-group">
                <label>Telephone</label>
                <input
                  className={`form-control ${
                    errors.numero ? "is-invalid" : ""
                  }`}
                  type="number"
                  name="numero"
                  {...register("numero", {
                    required: true,
                    pattern: /^[0-9]+$/,
                  })}
                />
                {errors.numero && (
                  <span className="text text-danger">*Numero invalide</span>
                )}
              </FormGroup>

              <FormGroup className="form-group">
                <label>Email</label>
                <input
                  className={`form-control ${errors.email ? "is-invalid" : ""}`}
                  type="email"
                  name="email"
                  {...register("email", {
                    required: true,
                    pattern: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/,
                  })}
                />
                {errors.email && (
                  <span className="text text-danger">Email invalide</span>
                )}
              </FormGroup>
              <FormGroup className="form-group">
                <label>Login </label>
                <input
                  className={`form-control ${errors.login ? "is-invalid" : ""}`}
                  type="text"
                  name="login"
                  {...register("login", {
                    required: true,
                    pattern: /^[a-zA-Z0-9_-]{3,20}$/,
                  })}
                />
                {errors.login && (
                  <span className="text text-danger">
                    Le login doit contenir au moins 3 caracteres
                  </span>
                )}
              </FormGroup>
              <br />

              <FormGroup className="form-group">
                <label>Password </label>
                <input
                  className={`form-control ${
                    errors.password ? "is-invalid" : ""
                  }`}
                  type="password"
                  name="password"
                  {...register("password", {
                    required: true,
                    pattern:
                      /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,20}$/,
                    minLength: 8,
                  })}
                />
                {errors.password && (
                  <span className="text text-danger">
                    Le mot de passe doit contenir au moins 8 caractéres combiner
                    à des chiffres et symboles(!@#$%^&*()_+)
                  </span>
                )}
              </FormGroup>
              <br />

              <FormGroup className="form-group">
                <label>Solde:</label>
                <input
                  className={`form-control ${errors.solde ? "is-invalid" : ""}`}
                  type="number"
                  name="solde"
                  {...register("solde", {
                    required: true,
                    pattern: /^[0-9]+$/,
                    min: 1,
                  })}
                />
                {errors.solde && (
                  <span className="text text-danger">Solde invalide</span>
                )}
              </FormGroup>

              <button
                type="submit"
                disabled={isSubmitting}
                className="btn btn-primary"
              >
                Submit
              </button>
            </Form>
          </Modal.Body>
          {/* </div> */}
        </div>
      </div>
    </Modal>
  );
};
export default AddAccountForm;
