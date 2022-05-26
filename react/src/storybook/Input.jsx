import React from "react";

const Input = ({ onChange }) => {
  const handleChange = (e) => {
    const value = e.target.value;
    console.log(`handleChange value ${value}`);
    onChange()
  };

  return (
    <>
      <h1>input</h1>
      <input onChange={handleChange}></input>
    </>
  );
};
export default Input;
