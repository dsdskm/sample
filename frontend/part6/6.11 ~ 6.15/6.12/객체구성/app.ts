type MyObject = {
    name?: string;
    age: number;
    getFamilyName: () => string;
    getLastName: () => string;
    getBloodType: () => string;
}

const myObj = Object.create(null, {
    name: {
        value: 'Kim mintae',
        writable: false,
        configurable: false
    }
})

delete myObj.name;