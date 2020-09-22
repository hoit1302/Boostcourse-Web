// 
document.getElementById("nav-cart-count");
// 더 나아가 속성들을 쓸 수 있음.
document.getElementById("nav-cart-count").id;
document.getElementById("nav-cart-count").className;

//
document.querySelector("#nav-cart-count");
document.querySelector(".nav-line-2");
// css 셀렉터 문법 적용

// 노드 리스트
document.querySelectorAll("div")
document.querySelectorAll("div")[0]

// DOM 위아래이동 예시
function moveup() {
    $('#element3').after($('#element3').prev());
}

function movedown() {
    $('#element3').before($('#element3').next());
}


removeChild(child)
//  : 삭제
replaceChild(newChild, oldChild)
//  : 대체
appendChild(child)
// : 노드의 마지막 자식으로 주어진 엘리먼트 추가한다.
document.createElement(tagname)
// : tagname 엘리먼트 노드를 추가한다.
document.createTextNode(data)
// : 텍스트 노드를 추가한다.