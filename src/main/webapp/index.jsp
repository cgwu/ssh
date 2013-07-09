<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSH Demo Home Page</title>
</head>
<body>

<a href='<c:url value="main.jsp" />'>转去main.jsp</a>
<hr>
现在时间:<%= new java.util.Date() %><br />
<br>
test jstl(1.2): <br />
<ol>
<c:forEach begin="0" end="10" var="e">
	<li> 这是第${e }行</li>
</c:forEach>
</ol>
<hr>

</body>
</html>