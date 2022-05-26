import React from "react";

const Currying = () => {
  const currying1 = () => {
    const multiplyX = (x) => (a) => a * x;
    const result1 = multiplyX(3)(3);
    console.log(`result ${result1}`);
  };

  const currying2 = () => {
    const equation = (a, b, c) => (x) => x * a * b + c;
    const fomula = equation(2, 3, 4);
    const x = 10;
    const result = fomula(x);
    console.log(`result ${result}`);
  };

  currying1();
  currying2();

  return <>Currying</>;
};
export default Currying;
