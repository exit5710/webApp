<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-31
  Time: 오후 7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>응답내용</title>
	<script defer type="text/javascript">
		'use strict';
		window.onload = function () {
		};
	</script>
</head>

<body>
	<p>
		응답내용
	</p>
	<ul>
		<c:forEach var="response" items="${ansData.responses}" varStatus="status">
			<li>${status.index + 1}번 문항 : ${response}</li>
		</c:forEach>
	</ul>
	<p>
		사는곳 : ${ansData.res.location}
	</p>
	<p>
		나이 : ${ansData.res.age}
	</p>
</body>
</html>