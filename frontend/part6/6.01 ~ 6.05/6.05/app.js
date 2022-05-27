10 + 10;

const colors = ['red', 'yellow', 'black'];
const Colors = {
    blue: 'blue',
    green: 'green',
    white: 'white',
};

colors[1]
// 의미가 불분명하다

const red = colors[0];
const yellow = colors[1];
const black = colors[2];

// 코드의 타이핑량이 많아진다

// 구조분해 할당(오른쪽의 구조를 분해해서 왼쪽의 변수로 할당한다) 8~10라인과 16번라인은 동일하다

const [red, yellow, black] = colors;

// 생략하고 싶을때
const [, yellow] = colors;

// 객체를 구조분해 할당 (객체에서는 위치값이 없기때문에 순서가 중요하지 않다)
const {green, white} = Colors;
