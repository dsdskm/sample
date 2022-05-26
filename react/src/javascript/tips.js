import React from "react";
const Tips = () => {
  console.log(`[Tips]`);

  function print(person) {
    if (!person) {
      console.log("person이 없네요");
      return;
    }
    console.log(person.name);
  }
  const person = null;
  print(person);

  // &&
  const dog = {
    name: "멍멍이",
  };

  function getName(animal) {
    return animal && animal.name;
  }

  const name = getName();
  console.log(name); // undefined

  // ||
  const namelessDog = {
    name: "",
  };

  function getName(animal) {
    const name = animal && animal.name;
    return name || "이름이 없는 동물입니다.";
  }

  const name2 = getName(namelessDog);
  console.log(name2);

  // includes
  const calculateCircleArea = (r = 1) => Math.PI * r * r;
  console.log(calculateCircleArea());
  const isAnimal = (name) =>
    ["고양이", "개", "거북이", "너구리"].includes(name);

  console.log(isAnimal("개"));
  console.log(isAnimal("노트북"));

  // get
  function getSound(animal) {
    const sounds = {
      개: "멍멍!",
      고양이: "야옹~",
      참새: "짹짹",
      비둘기: "구구 구 구",
    };
    return sounds[animal] || "...?";
  }

  console.log(getSound("개"));
  console.log(getSound("비둘기"));

  function makeSound(animal) {
    const tasks = {
      개() {
        console.log("멍멍");
      },
      고양이() {
        console.log("고양이");
      },
      비둘기() {
        console.log("구구 구 구");
      },
    };
    if (!tasks[animal]) {
      console.log("...?");
      return;
    }
    tasks[animal]();
  }

  getSound("개");
  getSound("비둘기");

  // 비구조화 할당
  const object = { a: 1 };

  const { a, b = 2 } = object;
  console.log(a);
  console.log(b);

  const animal = {
    name: "멍멍이",
    type: "개",
  };

  const { name: nickname } = animal;
  console.log(nickname);

  // spread
  const slime = {
    name: "슬라임",
  };

  const cuteSlime = {
    ...slime,
    attribute: "cute",
  };

  const purpleCuteSlime = {
    ...cuteSlime,
    color: "purple",
  };

  console.log(slime);
  console.log(cuteSlime);
  console.log(purpleCuteSlime);

  const animals = ["개", "고양이", "참새"];
  const anotherAnimals = [...animals, "비둘기"];
  console.log(animals);
  console.log(anotherAnimals);

  const numbers = [1, 2, 3, 4, 5];

  const spreadNumbers = [...numbers, 1000, ...numbers];
  console.log(spreadNumbers); // [1, 2, 3, 4, 5, 1000, 1, 2, 3, 4, 5]

  // rest
  const purpleCuteSlime2 = {
    name: "슬라임",
    attribute: "cute",
    color: "purple",
  };

  const { color, ...cuteSlime2 } = purpleCuteSlime2;
  console.log(color);
  console.log(cuteSlime2);

  const { attribute, ...slime2 } = cuteSlime2;
  console.log(attribute);
  console.log(slime2);

  const numbers2 = [0, 1, 2, 3, 4, 5, 6];

  const [one, ...rest] = numbers2;

  console.log(one);
  console.log(rest);

  function sum(...rest) {
    return rest.reduce((acc, current) => acc + current, 0);
  }

  const result = sum(1, 2, 3, 4, 5, 6);
  console.log(result); // 21

  return <></>;
};

export default Tips;
