import React from "react";
import Users from "./Users";
import { UsersProvider } from "./UsersContext";

function ApiMain() {
  return (
    <UsersProvider>
      <Users />
    </UsersProvider>
  );
}

export default ApiMain;
