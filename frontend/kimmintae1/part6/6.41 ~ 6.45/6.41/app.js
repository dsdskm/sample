const simpleCamel = (text, splitter = ' ') => text.split(splitter)
                        .map((word, wi)=> word.split(' ')
                            .map((c, ci) => wi >0 && ci === 0 ? c.toUpperCase() :c.toLowerCase())
                            .join(''))
                        .join('');


function convertCamelName(name){
    let camelName = '';

    for(let i =0, newSpace = false; i < name.length; i++){
        if(name[i] == ' '){
            newSpace = true;
            continue;
        }

        if(newSpace){
            camelName = camelName + name[i].toUpperCase();
            newSpace = false;
        } else {
            camelName = camelName + name[i].toLowerCase();
        }
    }

    return camelName;
}

const camelName1 = convertCamelName('Kim min tae');
const camelName2 = simpleCamel('KIM MIN TAE');

console.log(camelName1);
console.log(camelName2);