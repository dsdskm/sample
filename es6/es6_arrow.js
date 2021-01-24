setTimeout(function(){
    console.log("settimeout");
  },1000);
  
  setTimeout(()=>{
    console.log("arrow");
  },1000);
  
  let newArr =[1,2,3,4,5].map((value)=>value * 2);
  
  console.log(newArr);