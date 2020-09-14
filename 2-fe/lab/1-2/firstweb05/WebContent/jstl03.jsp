<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 나 jstl 태그 라이브러리 쓸거에요 --%>

<%
	request.setAttribute("score", 83);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
	<c:when test="${ score >= 90 }">
		A학점입니다.
	</c:when>
	<c:when test="${ score >= 80 }">
		B학점입니다.
	</c:when>
	</c:choose>
</body>
</html>