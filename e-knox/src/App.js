import logo from "./logo.svg";
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./Components/Header";

import AdminPage from "./pages/admin/AdminPage";
import Home from "./pages/Home";
import TransactionPage from "./pages/admin/TransactionPage";
import Accounts from "./pages/admin/Accounts";
import UsersPage from "./pages/admin/UsersPage";
import ClientPage from "./pages/client/ClientPage";
import TransactionCli from "./pages/client/TransactionCli";

function App() {
  return (
    <div className="App">
      {/* <Header />
      <AdminPage /> */}

      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/admin" element={<AdminPage />}>
            {/* <Route path="*" element={<Home />} /> */}
            {/* Put a condition to verify if user log successfully as Admin */}
            <Route path="/admin/transactions" element={<TransactionPage />} />
            <Route path="/admin/accounts" element={<Accounts />} />
            <Route path="/admin/users" element={<UsersPage />} />
          </Route>
          <Route path="client" element={<ClientPage />}>
            <Route path="transactions" element={<TransactionCli />} />
          </Route>
        </Routes>
      </BrowserRouter>
      {/* <TransactionForm /> */}
    </div>
  );
}

export default App;
