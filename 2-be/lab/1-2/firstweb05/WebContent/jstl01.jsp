<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- 나 jstl 태그 라이브러리 쓸거에요 --%>
<c:set var="value1" scope="request" value="kang"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
성: ${value1 } <br>
<c:remove var="value1" scope="request" />
성 ${value1 } <br>
</body>
</html>