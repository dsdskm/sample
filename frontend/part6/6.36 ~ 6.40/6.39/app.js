const myIterable = {};

myIterable[Symbol.iterator] = function* (){
    let i = 1;
    while(i<=100){
        yield i++;
    }
};

for(const n of myIterable){
    console.log(n);
}