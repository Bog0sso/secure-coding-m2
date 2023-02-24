import React, { useState } from "react";
// import { useForm } from "react-hook-form";
const LoginForm = () => {
//   const {
//     register,
//     handleSubmit,
//     formState: { errors },
//   } = useForm();
//   const [isSubmitting, setIsSubmitting] = useState(false);
//   const ONLY_LETTERS = "Ce champs ne doit contenir que des lettres";
//   const submitAction = (data) => {
//     setIsSubmitting(true);

//     console.log(data);
//   };

  return (
    // <div>numDestinataire, Status status, double montant, Devise devise,</div>
    <div className="container">
      <div className="row mt-lg-n10 mt-md-n11 mt-n10 justify-content-center">
        <div className="col-xl-4 col-lg-8 col-md-7 mx-auto">
          <div className="card z-index-0">
            <div className="card-header card-header-tabs card-header-primary">
              <h4 className="card-title ">Ajout d'un compte</h4>
            </div>
            <div className="card-body">
              <h1>LOGIN FORM</h1>
              {/* <form onSubmit={handleSubmit(submitAction)}>
                <div className="form-group">
                  <label>Login </label>
                  <input
                    className={`form-control ${
                      errors.login ? "is-invalid" : ""
                    }`}
                    type="text"
                    name="login"
                    {...register("login", {
                      required: true,
                      pattern: /^[a-zA-Z]+$/,
                    })}
                  />
                  {errors.login && (
                    <span className="text text-danger">{ONLY_LETTERS}</span>
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
                      Le mot de passe doit contenir au moins 8 characteres
                      combiner à des chiffres et symboles
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
              </form> */}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default LoginForm;
