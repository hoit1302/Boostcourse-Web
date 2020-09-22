function ajax(data) {
    // ajax를 보내기 위해서는 XMLHttpRequest라는 객체를 만들어야 됩니다.
    var oReq = new XMLHttpRequest();
    // 이벤트를 처리하는 방식이라고 생각하기 때문에.
    oReq.addEventListener("load", function () {
        console.log(this.responseText);
    });
    oReq.open("GET", "./4.json");//parameter를 붙여서 보낼수있음. 
    oReq.send();
}
ajax();

// // 순서
// ajax()
// xmlhttlrequest 객체 만들기
// open // 서버 요청을 준비하고
// send // 서버로 날라감
// ajax() //실행 끝 (콜 스택에서 내려옴. 반환이 모두 됨)

// 콜백함수만 남아서 function() {} 따로 실행