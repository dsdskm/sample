let arr = [1,2,3,4];
let arr2 =[5,6,7,8];
let obj = {arr,arr2};
let ws = new WeakSet();
ws.add(arr);
ws.add(arr2);
ws.add(obj);

console.log(arr);
let arr = [1,2,3,4];
let arr2 =[5,6,7,8];
let obj = {arr,arr2};
// 객체 상태를 중복 없이 저장
let ws = new WeakSet();
ws.add(arr);
ws.add(arr2);
ws.add(obj);

console.log(arr);
