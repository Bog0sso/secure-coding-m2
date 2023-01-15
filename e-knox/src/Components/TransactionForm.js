import React, { useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";
const TransactionForm = () => {
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
    // <div>numDestinataire, Status status, double montant, Devise devise,</div>
    <div className="card">
      <div class="card-header text-center pt-4">
        <h5>Effectuez une transaction </h5>
      </div>
      <div className="card-body">
        <form onSubmit={handleSubmit(submitAction)}>
          <label>
            Nom Destinataire
            <input
              className="form-control"
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
          </label>
          <br />
          <label>
            Prenom Destinataire:
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
          </label>
          <br />
          <label>
            Numero Destinataire:
            <input
              className="form-control"
              type="number"
              name="numDest"
              {...register("numDest", {
                required: true,
                pattern: /^[0-9]+$/,
              })}
            />
            {errors.numDest && (
              <span className="text text-danger">
                Ce champs ne doit contenir que des chiffres
              </span>
            )}
          </label>
          <br />
          <label>
            Montant
            <input
              className="form-control"
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
          </label>
          <br />

          <button
            type="submit"
            disabled={isSubmitting}
            className="btn btn-primary"
          >
            Submit
          </button>
        </form>
      </div>
    </div>
  );
};

export default TransactionForm;
