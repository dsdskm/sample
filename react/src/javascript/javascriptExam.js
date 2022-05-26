import React from "react";
import ArrayExam from "./arrayExam";
import AsyncAwaitExam from "./asyncAwaitExam";
import ClassExam from "./classExam";
import ObejctExam from "./objectExam";
import PromiseExam from "./promiseExam";
import Tips from "./tips";
const JavascriptExam = () => {
  return (
    <>
      <ObejctExam />
      <ArrayExam />
      <ClassExam />
      <Tips />
      <PromiseExam />
      <AsyncAwaitExam />
    </>
  );
};

export default JavascriptExam;
