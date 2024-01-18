<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2022-06-08
  Time: 오후 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>racers</title>
		<link type="image/x-icon" rel="icon" href="./icon/html5.ico" />
		<link type="text/css" rel="stylesheet" href="./css/generalTab.css" />
		<link type="text/css" rel="stylesheet" href="./css/racerStyles.css" />
		<script type="text/javascript" src="./js/jquery-3.6.0.js"></script>
		<script type="text/javascript" src="./js/common.js"></script>
		<script type="text/javascript" src="./js/generalTab.js"></script>
		<script type="text/javascript" src="./js/racerScripts.js"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				fn_btnStop();
			});

			let submitContents = function () {
				let addRunner = document.getElementById("addRunner");
				addRunner.action = "./racerSave.do";
				//addRunner.submit();

				return false;
			};

			let showScreen = function (url) {
				let xhr = new XMLHttpRequest();

				xhr.onreadystatechange = function () {
					if (xhr.readyState === 4 && xhr.status === 200) {
						document.getElementById('screen1').style.display = 'none';
						document.getElementById('screen2').style.display = 'none';
						document.getElementById('etc').innerHTML = xhr.responseText;
					}
				};

				xhr.open('GET', url, true);
				xhr.send();
			};
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
				<li><a href="#etc">etc</a></li>
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
						First Name: <input type="text" name="firstName" id="firstName" /><br/>
						Last Name: <input type="text" name="lastName" id="lastName" /><br/>
						Gender:
						<select id="gender" name="gender">
							<option value="">--Please Select--</option>
							<option value="f">Female</option>
							<option value="m">Male</option>
						</select><br>
						Finish Time:
						<input type="text" id="minutes" name="minutes" size="10" maxlength="2" />(Minutes)
						<input type="text" id="seconds" name="seconds" size="10" maxlength="2" />(Seconds)<br/><br/>
						<input type="hidden" id="action" name="action" value="addRunner" />
						<!-- <button type="submit" name="btnSave" id="btnSave" onclick="submitContents(); return false;">Add Runner</button> -->
						<!-- <button type="submit" name="btnSave" id="btnSave">Add Runner</button> -->
						<button type="submit" name="btnSave" onclick="fn_btnSave(); return false;">Add Runner</button>
					</form>
				</div>
				<div id="etc">
					<h4>etc</h4>
					<div id="screen1">
						<h1>첫 번째 화면</h1>
						<button onclick="showScreen('./')">두 번째 화면으로 이동</button>
					</div>
					<div id="screen2" style="display: none">
						<h1>두 번째 화면</h1>
						<button onclick="showScreen('./')">첫 번째 화면으로 이동</button>
					</div>
				</div>
			</div>
		</div>
		<footer>
			<h4>Congratulations to all our finishers!</h4>
			<input type="text" id="timeRepeat" name="timeRepeat" maxlength="2" />
			<button id="btnStart">Start Page Updates</button>
			<button id="btnStop">Stop Page Updates</button>
			<br/>
			<span id="freq"></span><span id="note"></span>
			<br/><br/>
			Last Updated : <span id="updatedTime"></span>
		</footer>
	</body>
</html>