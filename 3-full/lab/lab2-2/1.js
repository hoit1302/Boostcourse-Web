function run() {
    console.log("start");

    // 콜백함수: 나중에 실행되는 함수
    // setTimeout의 실행은 비동기(asynchronous)로 실행되어 동기적인 다른 실행이 끝나야 실행됨.
    setTimeout(function() {
        var msg = "hello codesquad";
        console.log(msg);  //이 메시지는 즉시 실행되지 않습니다.
    }, 2000); //ms

    console.log("end");

}
console.log("main start")
run();
console.log("main end")
