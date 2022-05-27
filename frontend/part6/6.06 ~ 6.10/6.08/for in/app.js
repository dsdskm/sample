const arr = ['a', 'b', 'c', 'd'];

for (const index in arr){
    console.log(arr[index]);
}

const obj = {
    color: 'red',
    width: 200,
    height: 200,
};

for (const key in obj){
    console.log(key)
}