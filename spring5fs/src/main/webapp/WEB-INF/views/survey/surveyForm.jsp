<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-31
  Time: 오후 6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>설문조사</title>
</head>

<body>
	<h2>설문조사</h2>
	<form method="post">
		<c:forEach var="question" items="${questions}" varStatus="status">
			<p>
				${status.index + 1}. ${question.title}<br/>
				<c:if test="${question.choice}">
					<c:forEach var="option" items="${question.options}">
						<label>
							<input type="radio" name="responses[${status.index}]" value="${option}">${option}
						</label>
					</c:forEach>
				</c:if>
				<c:if test="${!question.choice}">
					<label>
						<input type="text" name="responses[${status.index}]" />
					</label>
				</c:if>
			</p>
		</c:forEach>
		<p>
			4.사는곳<br/>
			<label>
				<input type="text" name="res.location" />
			</label>
		</p>
		<p>
			5.나이<br/>
			<label>
				<input type="text" name="res.age" />
			</label>
		</p>
		<input type="submit" value="전송">
	</form>
</body>
</html>