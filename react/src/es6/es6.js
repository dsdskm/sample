import Shape2 from "./Shape2";
import LibMath from "./math";
class Shape {
  static create(x, y) {
    return new Shape(x, y);
  }

  name = "Shape";
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }

  move() {
    return this.x * this.y;
  }
  area() {
    return 0;
  }
}

function ES6() {
  const operator = () => {
    var array1 = [`one`, `two`];
    var array2 = [`three`, `four`];

    const combined = [...array1, array2];
    console.log(`combined ${combined}`);

    const [first, second, three = `empty`, ...others] = array1;
    console.log(`${first} ${second} ${three} ${others}`);
    function func(...args) {
      var [first, ...others] = args;
    }
  };

  const operator2 = () => {
    var objectOne = { one: 1, two: 2, other: 0 };
    var objectTwo = { three: 3, four: 4, other: -1 };
    var combined = { ...objectOne, ...objectTwo };
    console.log(combined);
    var { other, ...others } = combined;
    console.log(other, others);
  };

  const es6class = () => {
    const shape = Shape.create(10, 20);
    console.log(shape.move());
    const shape2 = Shape2.create(30, 30);
    console.log(shape2.move());
  };

  const arrowFunction = (first, second) => first * second;
  function addNumber(num) {
    return function (value) {
      return num + value;
    };
  }
  const currying = (num) => (value) => num + value;

  const keyValue = () => {
    var x = 0;
    var y = 0;
    var obj = { x, y }; // 자동으로 변수명을 키값으로 함
    console.log(obj);
    var randomKeyString = "other";
    var combined = {
      ["one" + randomKeyString]: "some value",
    };
    console.log(combined);
    var obj2 = {
      x,
      methodA() {
        console.log("A");
      },
      methodB() {
        return 0;
      },
    };
    console.log(obj2);
    obj2.methodA();
  };

  const keyAssign = () => {
    var list = [0, 1];
    var [item1, item2, item3 = -1] = list;
    console.log(item1, item2, item3);
    [item2, item1] = [item1, item2];
    var obj = {
      key1: "one",
      key2: "two",
    };
    var { key1: newKey1, key2, key3 = "default key3 value" } = obj;
    console.log(newKey1, key2, key3);
  };

  const libDependency = () => {
    var math = LibMath;
    console.log(math.pi);
    console.log(math.sum(2, 3));
  };

  operator();
  operator2();
  es6class();
  arrowFunction();
  currying();
  keyValue();
  keyAssign();
  libDependency();

  return <>ES6</>;
}

export default ES6;
