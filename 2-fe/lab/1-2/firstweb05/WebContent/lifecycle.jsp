<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello!
<%
	System.out.print("jspService()"); // System과 out의 프린트는 출력하는 위치가 다른 거임
%>

<%!
	public void jspInit(){
	System.out.print("jspInit()!!!!");
}

// 선언식임 여러분이 이 클래스에 메서드를 선언한다던가 필드를 선언할 때 넣어주시면 Service라는 메서드 내에 만들어지는 게 아니라 이 메서드 바깥쪽에 해당 코드들이 만들어지게 할 수 있어요.

	public void jspDestroy(){
	System.out.print("jspDestroy()");
}
%> 
</body>
</html>