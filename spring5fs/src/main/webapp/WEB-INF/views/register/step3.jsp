<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-30
  Time: 오후 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입완료</title>
</head>
<body>
	<p>
		<strong>${registerRequest.name}님</strong>
		회원 가입을 완료했습니다.
	</p>
	<p><a href="<c:url value='/main'/>">[첫 화면 이동]</a></p>
</body>
</html>