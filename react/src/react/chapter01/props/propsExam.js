import React from "react";
import Hello from "./Hello";
import Wrapper from "./Wrapper";
const PropsExam = () => {
  console.log("[PropsExam]");
  return (
    <>
      <Wrapper>
        <Hello name="JAMES" color="red" />
        <Hello name="KAI" color="pink" />
      </Wrapper>
    </>
  );
};

export default PropsExam;
