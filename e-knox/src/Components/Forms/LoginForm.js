import React from "react";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { Modal } from "react-bootstrap";
const LoginForm = (props) => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const [isSubmitting, setIsSubmitting] = useState(false);
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
      <div className="row mt-lg-n8 mt-md-n8 mt-n6 justify-content-center">
        <div className="col-md-8 col-md-8 col-md-7 mx-auto">
          {/* <div className=" card"> */}
          <Modal.Header
            className="modal-header card-header-tabs card-header-primary"
            closeButton
          >
            <Modal.Title className="card-title ">
              <h4>Connexion</h4>
            </Modal.Title>
          </Modal.Header>
          <Modal.Body className="card-body">
            <form onSubmit={handleSubmit(submitAction)}>
              <div className="form-group">
                <label>Login </label>
                <input
                  className={`form-control ${errors.login ? "is-invalid" : ""}`}
                  type="text"
                  name="login"
                  {...register("login", {
                    required: true,
                    pattern: /^[a-zA-Z]+$/,
                  })}
                />
                {errors.login && (
                  <span className="text text-danger">Login incorrect</span>
                )}
              </div>
              <br />

              <div className="form-group">
                <label>Password </label>
                <input
                  className={`form-control ${
                    errors.password ? "is-invalid" : ""
                  }`}
                  type="text"
                  name="password"
                  {...register("password", {
                    required: true,
                    pattern: /[^a-zA-Z0-9]+$/,
                    minLength: 8,
                  })}
                />
                {errors.password && (
                  <span className="text text-danger">
                    Mot de passe incorrect
                  </span>
                )}
              </div>
              <br />
              <button
                type="submit"
                // disabled={isSubmitting}
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
export default LoginForm;
