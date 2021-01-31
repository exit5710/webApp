<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-30
  Time: 오후 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>${title}</title>
	<style type="text/css">
		.box {
			width: 80px;
			cursor: pointer;
		}
	</style>
	<script defer type="text/javascript">
		'use strict';
		let actionPage = function (_target) {
			let page = '';
			let listForm = document.getElementById('listForm');

			switch (_target.id) {
				case 'main' :
					page += 'main';
					listForm.method = 'get';
					break;
				case 'register' :
					page += 'register/step1';
					break;
				case 'survey' :
					page += 'survey';
					listForm.method = 'get';
					break;
			}

			listForm.action = page;
			listForm.submit();
		};
	</script>
</head>

<body>
	<form id="listForm" method="post">
		<div>
			<input type="button" id="main" class="box" value="main" onclick="actionPage(this);" /><br/>
			<input type="button" id="register" class="box" value="register" onclick="actionPage(this);" /><br/>
			<input type="button" id="survey" class="box" value="survey" onclick="actionPage(this);" /><br/>
		</div>
	</form>
</body>
</html>
