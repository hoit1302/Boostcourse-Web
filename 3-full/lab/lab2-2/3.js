var el = document.querySelector(".outside");
// addEventListener 함수의 두 번째 인자는 함수입니다.

// 이 함수는 나중에 이벤트가 발생할 때 실행되는 함수로 
// 이벤트핸들러(Event Handler) 또는 이벤트리스너(Event Listener)라고 합니다.

// 콜백함수는 이벤트가 발생할 때 실행됩니다. 

el.addEventListener("click", function (event) {
    console.log("clicked");
    console.log(event)
    var target = event.target;
    console.log(target.className, target.nodeName);
    console.log(target.innerText);
    debugger; // 걸림. 개발자 도구에서 target. 으로 많은 엘리먼트 확인 가능
}, false);
