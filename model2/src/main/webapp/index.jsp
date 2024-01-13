<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2022-06-07
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>index</title>
		<link type="image/x-icon" rel="icon" href="./icon/html5.ico" />
		<script type="text/javascript">
			window.onload = function () {
				console.log('model2 index');
			}
		</script>
	</head>
	<body>
		<div>welcome model2</div>
		<div><a href="${pageContext.request.contextPath}/racerView.do">racerView</a></div>
	</body>
</html>