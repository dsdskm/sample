// destructuring

let data = ["crong","honux","jk","jinny"];
let [jisu,,jung] = data;
console.log(jisu,jung);

let obj = {
    name:"crong",
    address:"Korea",
    age:10
  }
  
  let {name,age} = obj;
  console.log(name,age);
  
  let {name:myName,age:myAge} = obj;
  console.log(myName,myAge);

  var news=[
    {
      "title":"sbs",
      "imageUrl":"sbs_image",
      "newslist":[
        "1기사",
        "2기사"
      ]
    },
    {
      "title":"mbc",
      "imageUrl":"mbc_image",
      "newslist":[
        "1title",
        "2title"
      ]
    }
  ];
  
  // let [,mbc] = news;
  // let {title,imageUrl} = mbc;
  // console.log(title,imageUrl);
  
  let [,{title,imageUrl}]= news;
  console.log(imageUrl);
  
  function getNewsList([,{newslist}]){
    console.log(newslist);
  }
  
  getNewsList(news);


  document.querySelector("div").addEventListener("click",function({target}){
    console.log(target.tagName);
  });