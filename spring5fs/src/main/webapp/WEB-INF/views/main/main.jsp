<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-31
  Time: 오후 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>springMVC main</title>
</head>

<body>
	<p>
		환영합니다.
	</p>
	<p>
		<a href="<c:url value="/register/step1" /> ">[회원 가입하기]</a>
	</p>
</body>
</html>