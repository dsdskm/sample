import React from "react";
const ObejctExam = () => {
  console.log(`[ObejctExam]`);
  // 객체 안에 함수 넣기
  const dog = {
    name: "멍멍이",
    sound: "멍멍!",
    say: function () {
      // 화살표 함수로 선언하면 this 동작 안한다
      console.log(this.sound);
    },
  };
  dog.say();

  // getter & setter
  const numbers = {
    _a: 1,
    _b: 2,
    calculate() {
      console.log(`calculate`);
      this.sum = this._a + this._b;
    },
    get a() {
      console.log(`get a ${this._a}`);
      return this._a;
    },
    get b() {
      console.log(`get b ${this._b}`);
      return this._b;
    },
    set a(value) {
      console.log(`set a ${value}`);
      this._a = value;
    },
    set b(value) {
      console.log(`set b ${value}`);
      this._b = value;
    },
  };

  numbers.a = 10;
  numbers.b = 20;
  console.log(`a ${numbers.a} b ${numbers.b}`);
  numbers.calculate();

  return <></>;
};

export default ObejctExam;
