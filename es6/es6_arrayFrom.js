function addMark(){
    let newArray = Array.from(arguments);
    
    let newData = newArray.map(function(value){
      return value + "@";
    });
    
    console.log(newData);
  }
  
  addMark(1,2,3,4,5);