<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/27
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>测试out</title>
	</head>
	<body>
		<div>
			未知值 =
			<c:out value="${unknowvalue}"></c:out>
		</div>
		<div>
			未知值(默认) =
			<c:out value="${unknowvalue}" default="unknow"></c:out>
		</div>
		<div>
			转义值 =
			<c:out value="<script>alert(1)</script>">" default=></c:out>
		</div>
	</body>
</html>
