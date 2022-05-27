let age = 1;

if (age === 1){
    console.log(1);
} else if (age === 2) {
    console.log(2);
} else if (age === 3){
    console.log(3)
} else {
    console.log('??')
}

switch(age) {
    case 1:
        console.log(1);
        break;
    case 2:
        console.log(2);
        break;
    case 3:
        console.log(3);
        break;
    default:
        console.log('??')
        break;
}