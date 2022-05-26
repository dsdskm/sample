import React from "react";

function Hello({ color, name, age }) {
  return (
    <>
      <div style={{ color: color }}>안녕하세요 {name}</div>
      <div style={{ color: color }}>제 나이는 {age}</div>
    </>
  );
}

Hello.defaultProps = {
  age: 15,
};
export default Hello;
