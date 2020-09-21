function printName(firstname) {
    var myname = "jisu";
    return myname + " " +  firstname;
}
console.log(printName());



function printName2(firstname) {
    
    var inner = function() { // 함수 표현식
        return "inner value";
    }
    var result = inner();
    console.log("name is " + result);
}
printName2();



function printName3(firstname) {
    
    // var result = inner(); // 에러
    // console.log("name is " + result);
    // 호이스팅이 발생해도
    // var inner; 이렇게만.
    
    var inner = function() {  // 함수 표현식
        return "inner value";
    }
}
printName3();



// 호이스팅(hoisting) 발생. 끌어 올린다.
function printName4(firstname) {
    
    var result = inner();
    console.log(typeof inner);
    console.log("name is " + result);
    
    function inner() { // 표현식이 함수 선언문으로 바뀜.
        return "inner value";
    }
}
printName4();

// 4 == 5
function printName5(firstname) {
    
    function inner() {
        return "inner value";
    }
    var result = inner();
    console.log(typeof inner);
    console.log("name is " + result);
    
    
}
printName5();


//argument
// 이런 특성을 가지고 있으나 좋지 않은 방법
function func_a() {
    console.log(arguments);
    for (var i = 0 ; i < arguments.length; i++)
        console.log(arguments[i]);
}
func_a(1,2,3)

function func_b() {
    console.log("My name is", arguments[2]);
}
func_b(1,2,"jueun")

function func_c() {
    if (arguments.length < 3) return;
    console.log("return 안됨");
}
func_c(1,"jueun")



// arrow funcion
// 점점 많이 사용되고 있는 syntax
function getName(name) {
    return "Kim " + name ;
 }
 
 //위 함수는 아래 arrow함수와 같다.
 // 일종의 함수 표현식
 // => 이렇게 return
 var getName = (name) => "Kim " + name;
 