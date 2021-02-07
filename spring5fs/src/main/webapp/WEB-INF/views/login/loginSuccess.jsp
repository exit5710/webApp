<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-02-07
  Time: 오후 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="login.title" /></title>
</head>

<body>
	<p>
		<spring:message code="login.done" />
	</p>
	<p>
		<a href="<c:url value='/main'/>">[<spring:message code="go.main" />]</a>
	</p>
</body>
</html>