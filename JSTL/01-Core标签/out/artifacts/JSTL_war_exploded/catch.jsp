<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/27
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>测试catch</title>
	</head>
	<body>
		<c:catch var="myex">
			<%
				int i = 1/0;
			%>
		</c:catch>
		<div>异常:${myex}</div>
		<div>异常:${myex.message}</div>
		<div>异常:${myex.stackTrace}</div>
	</body>
</html>
