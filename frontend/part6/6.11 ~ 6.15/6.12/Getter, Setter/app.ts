class Person {
    _bloodType: string;

    constructor(bloodType: string) {
        this._bloodType = bloodType;
    }

    set bloodType(btype: string){
        if(btype === 'A' || btype === 'B' || btype === 'O' || btype === 'AB'){
            this._bloodType = btype;
        }
    }

    get bloodType(){
        return  `${this._bloodType} 형`
    }
}

const p1 = new Person('B');

p1.bloodType;
p1.bloodType = 'C';