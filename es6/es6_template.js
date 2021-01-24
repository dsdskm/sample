const data =[
    {
      name:'conffe-bean',
      order : true,
      items:['americano','milk','green-tea']
      
    },
    {
      name:'starbucks',
      order : false,
    },
    {
      name:'coffee-king',
      order:true,
      items:['americano','latte']
    }
  ];
  
  function fn(tags,name,items){
    if(typeof items ==="undefined"){
      items ="<span style='color:red'>주문 가능 상품이 없습니다</span>";
    }
    return (tags[0] + name + tags[1] + items + tags[2]);
  }
  
  data.forEach((v)=>{
    console.log("foreach");
    let template = fn`<div>welcome ${v.name} !!</div>
  <h2>주문가능항목</h2><div>${v.items}</div>`;
    document.querySelector("#message").innerHTML += template;
  });