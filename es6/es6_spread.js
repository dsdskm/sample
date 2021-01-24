let pre = ["apple","orange",100];
// 배열을 펼친다
let newData = [...pre];
console.log(pre,newData);

let pre = [100,200,300];

function sum(a,b,c){
  return a+b+c;
}

console.log(sum.apply(null,pre));
console.log(sum(...pre));