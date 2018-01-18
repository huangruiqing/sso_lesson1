<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sso login</title>
</head>
<body>
<h1>this is login jsp of sso</h1>
<hr>
<form action="/sso/login" method="post">
	sys : <input type="text" name="sys" value="${sys }"/><br>
	rUrl: <input name="reUrl" value="${reUrl}"><br>
	user: <input type="text" name="userName" value="user"/><br>
	pswd: <input type="text" name="password" value="1"/><br>
	
	<input type="submit" value="LOGIN"/>
</form>
</body>
</html>