// let 예제
/*
  블록 단위에서만 제공된다
*/

var name = "global var";

function home() {
  var homevar = "homevar";
  for (let i = 0; i < 100; i++) {
    console.log(i);
  }
  //console.log(i);
}

home();

// 각자 다른 결과
var list = document.querySelectorAll("li");
for (let i = 0; i < list.length; i++) {
  list[i].addEventListener("click", function () {
    console.log(i + "번째 리스트 입니다.");
  });
}

// 모두 같은 결과
for (var i = 0; i < list.length; i++) {
  list[i].addEventListener("click", function () {
    console.log(i + "번째 리스트 입니다.");
  });
}
