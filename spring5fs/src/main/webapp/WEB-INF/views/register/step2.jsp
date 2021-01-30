<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-29
  Time: 오후 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입</title>
	<script defer type="text/javascript">
		'use strict';
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
			nextStep.submit();
		};
	</script>
</head>
<body>
	<h2>회원정보 입력</h2>
	<form id="nextStep" method="post">
		<p>
			<label for="email">이메일</label><br/>
			<input type="text" id="email" name="email" />
		</p>
		<p>
			<label for="name">이름</label><br/>
			<input type="text" id="name" name="name" />
		</p>
		<p>
			<label for="password">비밀번호</label><br/>
			<input type="password" id="password" name="password" />
		</p>
		<p>
			<label for="confirmPassword">비밀번호 확인</label><br/>
			<input type="password" id="confirmPassword" name="confirmPassword" />
		</p>
		<input id="step3" type="button" value="가입완료" onclick="registerForm();" />
	</form>
</body>
</html>