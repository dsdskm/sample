function myFn(x){
    return x + 100;
}

const result = myFn(10, 20);

const myFnV2 = function (){
    return 100;
}

myFnV2();
myFnV2.call();
myFnV2.apply();

(function (){
    console.log('즉시 실행 함수 실행!');
})()