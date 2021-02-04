<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-29
  Time: 오후 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="member.register" /></title>
	<script defer type="text/javascript">
		'use strict';
		window.onload = function () {
			let springAttribute = '${registerRequest.email}';
			if (springAttribute != '') {
				window.alert('입력한 이메일은 이미 등록되어있습니다.');
			}
		};

		let registerForm = function () {
			let email = document.getElementById('email');
			let name = document.getElementById('name');
			let password = document.getElementById('password');
			let confirmPassword = document.getElementById('confirmPassword');

			if (email.value === '') {
				window.alert('이메일을 입력해주세요.');
				email.focus();
				return false;
			} else if (name.value === '') {
				window.alert('이름을 입력해주세요.');
				name.focus();
				return false;
			} else if (password.value === '') {
				window.alert('비밀번호를 입력해주세요.');
				password.focus();
				return false;
			} else if (confirmPassword.value === '') {
				window.alert('비밀번호를 입력해주세요.');
				confirmPassword.focus();
				return false;
			}

			if (password.value !== confirmPassword.value) {
				window.alert('비밀번호가 일치하지 않습니다.');
				password.focus();
				return false;
			}

			let nextStep = document.getElementById('nextStep');
			nextStep.action = './step3';

			// let createInput = document.createElement('input');
			// createInput.name = "hobby";
			// createInput.value = 'computer';
			// nextStep.appendChild(createInput);

			nextStep.submit();
		};
	</script>
</head>

<body>
	<h2><spring:message code="member.info" /></h2>
	<form:form id="nextStep" method="post" modelAttribute="registerRequest">
		<p>
			<label for="email"><spring:message code="email" /></label><br/>
			<form:input path="email" />
			<form:errors path="email" />
		</p>
		<p>
			<label for="name"><spring:message code="name" /></label><br/>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<label for="password"><spring:message code="password" /></label><br/>
			<form:password path="password" />
			<form:errors path="password" />
		</p>
		<p>
			<label for="confirmPassword"><spring:message code="password.confirm" /></label><br/>
			<form:password path="confirmPassword" />
			<form:errors path="c" />
		</p>
		<input id="step3" type="button" value="<spring:message code="register.btn" />" onclick="registerForm();" />
	</form:form>
</body>
</html>