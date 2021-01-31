<%--
  Created by IntelliJ IDEA.
  User: kiYoung-
  Date: 2021-01-31
  Time: 오후 6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>설문조사</title>
</head>

<body>
	<h2>설문조사</h2>
	<form method="post">
		<p>
			1.당신의 역할은?<br/>
		</p>
		<label>
			<input type="radio" name="responses[0]" value="서버" />서버 개발자
		</label>
		<label>
			<input type="radio" name="responses[0]" value="프론트" />프론트 개발자
		</label>
		<label>
			<input type="radio" name="responses[0]" value="풀스택" />풀스택 개발자
		</label>
		<p>
			2.가장많이 사용하는 개발도구는?<br/>
		</p>
		<label>
			<input type="radio" name="responses[1]" value="eclipse" />eclipse
		</label>
		<label>
			<input type="radio" name="responses[1]" value="intellij" />intellij
		</label>
		<label>
			<input type="radio" name="responses[1]" value="sublime" />sublime
		</label>
		<p>
			3.하고싶은 말<br/>
			<label>
				<input type="text" name="responses[2]" />
			</label>
		</p>
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