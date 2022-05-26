import React from "react";
const ArrayExam = () => {
  console.log(`[ArrayExam]`);
  // for...of
  let numbers = [10, 20, 30, 40, 50];
  for (let number of numbers) {
    console.log(`number ${number}`);
  }
  // for...in
  const doggy = {
    name: "멍멍이",
    sound: "멍멍",
    age: 2,
  };
  for (let key in doggy) {
    console.log(`${key} ${doggy[key]}`);
  }

  console.log(Object.entries(doggy));
  console.log(Object.keys(doggy));
  console.log(Object.values(doggy));

  // foreach
  const superheroes = ["아이언맨", "캡틴 아메리카", "토르", "닥터 스트레인지"];
  superheroes.forEach((hero) => {
    console.log(hero);
  });

  // map
  const array = [1, 2, 3, 4, 5, 6, 7, 8];
  const square = (n) => n * n;
  const squared = array.map(square);
  console.log(squared);

  // indexOf
  const index = superheroes.indexOf("토르");
  console.log(`index ${index}`);

  // findIndex
  const todos = [
    {
      id: 1,
      text: "자바스크립트 입문",
      done: true,
    },
    {
      id: 2,
      text: "함수 배우기",
      done: true,
    },
    {
      id: 3,
      text: "객체와 배열 배우기",
      done: true,
    },
    {
      id: 4,
      text: "배열 내장함수 배우기",
      done: false,
    },
  ];
  const index2 = todos.findIndex((todo) => todo.id === 3);
  console.log(`index2 ${index2}`);

  // find
  const todo = todos.find((todo) => todo.id === 3);
  console.log(todo);

  // filter
  const tasksNotDone = todos.filter((todo) => todo.done === false);
  console.log(tasksNotDone);

  // splice
  numbers.splice(index, 1);
  console.log(numbers);

  // slice
  const sliced = numbers.slice(0, 2);
  console.log(sliced);

  // shift
  const numbers2 = [10, 20, 30, 40];
  console.log(numbers2.shift());

  // pop
  console.log(numbers2.pop());

  // unshift
  numbers2.unshift(5);
  console.log(numbers2);

  // concat
  const arr1 = [1, 2, 3];
  const arr2 = [4, 5, 6];
  const arr3 = arr1.concat(arr2);
  console.log(arr3);

  // join
  console.log(array.join());
  console.log(array.join(" "));
  console.log(array.join("|"));

  // reduce
  let sum = arr3.reduce((a, b) => a + b, 0);
  console.log(`sum ${sum}`);
  return <></>;
};

export default ArrayExam;
