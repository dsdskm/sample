const obj = {
    name : 'Min Tae',
    age: 40,
    getFamilyName: function () {
        return 'Kim';
    },
    getLastName: () => 'Kim',
    getBloodType(){
        return 'B';
    }
}

obj.name;
obj.age;
obj.getFamilyName();
obj.getBloodType();

obj.age = 200;
obj.age = -500;