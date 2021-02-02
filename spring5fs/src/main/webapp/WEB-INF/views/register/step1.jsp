<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-29
  Time: 오후 6:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="member.register" /></title>
	<script defer type="text/javascript">
		'use strict';
		let check = function() {
			let agree = document.getElementById('agree').checked;
			if (!agree) {
				window.alert('약관에 동의해주세요.');
				return false;
			}

			let nextStep = document.getElementById('nextStep');
			nextStep.submit();
		};
	</script>
</head>

<body>
	<h2><spring:message code="term" /></h2>
	<p>약관 내용</p>
	<form id="nextStep" action="step2" method="post">
		<label>
			<input id="agree" type="checkbox" name="agree" value="true" />
			<spring:message code="term.agree" />
		</label>
		<input id="step2" type="button" value="<spring:message code="next.btn" />" onclick="check();"/>
	</form>
</body>
</html>