var healthObj = {
    showLeath : function(){
      console.log("오늘은운동시간 : "+this.lastTime);
    }
  }
  
  const myHealth = Object.create(healthObj);
  myHealth.healthTime = "11:20";
  myHealth.name = "crong";
  
  console.log(myHealth);
  
  const yourHealth = Object.assign(Object.create(healthObj),{
    name:"crong",
    lastTime:"11:20"
  });
  
  console.log(yourHealth);
  
  const ourHealth = Object.assign({},healthObj,{
    "name":"crong",
    "lastTime":"11:20",
    "age":99
  });
  
  console.log(ourHealth);