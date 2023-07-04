<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2022-06-08
  Time: 오후 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>racers</title>
	<link rel="icon" href="./icon/html5.ico" />
	<link type="text/css" rel="stylesheet" href="./css/racerStyles.css" />
	<script type="text/javascript" src="./js/jquery-3.6.0.js"></script>
	<script type="text/javascript" src="./js/common.js"></script>
	<script type="text/javascript" src="./js/racerScripts.js"></script>
	<script type="text/javascript">
		function submitContents() {
			let addRunner = document.getElementById("addRunner");
			return false;
			/*
			addRunner.action = "./racerSave.do";
			addRunner.submit();
			*/
		}
	</script>
</head>

<body>
<header>
	<h2>2022 Race Finishers!</h2>
</header>
<div class="main">
	<ul class="idTabs">
		<li><a href="#male">Male Finishers</a></li>
		<li><a href="#female">Female Finishers</a></li>
		<li><a href="#all">All Finishers</a></li>
		<li><a href="#new">Add New Finisher</a></li>
	</ul>
	<div class="tabcontent">
		<div id="male">
			<h4>Male Finishers</h4>
			<ul id="finishers_m"></ul>
		</div>
		<div id="female">
			<h4>Female Finishers</h4>
			<ul id="finishers_f"></ul>
		</div>
		<div id="all">
			<h4>All Finishers</h4>
			<ul id="finishers_all"></ul>
		</div>
		<div id="new">
			<h4>All Finishers</h4>
			<form id="addRunner" name="addRunner" method="POST">
				First Name: <input type="text" name="firstName" id="firstName" /><br />
				Last Name: <input type="text" name="lastName" id="lastName" /><br />
				Gender: <select id="gender" name="gender">
				<option value="">--Please Select--</option>
				<option value="f">Female</option>
				<option value="m">Male</option>
			</select><br>
				Finish Time:
				<input type="text" id="minutes" name="minutes" size="10" maxlength="2" />(Minutes)
				<input type="text" id="seconds" name="seconds" size="10" maxlength="2" />(Seconds)<br /><br />
				<input type="hidden" id="action" name="action" value="addRunner" />
				<!-- <button type="submit" name="btnSave" id="btnSave" onclick="submitContents(); return false;">Add Runner</button> -->
				<!--  <button type="submit" name="btnSave" id="btnSave">Add Runner</button> -->
				<button type="submit" name="btnSave" onclick="fn_btnSave(); return false;">Add Runner</button>
			</form>
		</div>
	</div>
</div>
<footer>
	<h4>Congratulations to all our finishers!</h4>
	<button id="btnStart">Start Page Updates</button>
	<button id="btnStop">Stop Page Updates</button>
	<br />
	<span id="freq"></span>
	<br /><br />
	Last Updated : <span id="updatedTime"></span>
</footer>
</body>
</html>