const sumV2 = (a, b, ...args) => {
    let s = 0;

    for(let i =0; i< args.length; i++){
        s = s + args[i];
    }

    return s;
}

const ten = x => 100 + x;
const ten2 = (x,y) => 100 + x + y;

function* gen(){
    yield 10;
    yield 20;
    return 30;
}

const g = gen();

console.log(g)

g.next();
g.next();
g.next();

async function myTask() {
    
}