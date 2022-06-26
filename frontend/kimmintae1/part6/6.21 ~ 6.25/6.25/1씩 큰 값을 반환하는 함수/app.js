let saveNumber = 1;

function increment(){
    return saveNumber++;
}

console.log(increment());
console.log(increment());

saveNumber = 200;

console.log(increment());