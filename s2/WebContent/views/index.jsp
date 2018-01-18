<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>s2</title>
</head>
<body>
<h1>this is jsp of s2</h1>
<hr />

<h1>userName:${user eq null ? '未登录' : user}</h1>
<a href="http://sso.com:8901/sso/login?sys=s2&reUrl=http://s2.com:8903/s2/result">我要登录</a>
<hr />
<a href="http://s1.com:8902/s1/index">s1系统</a>
<hr />
<a href="http://s2.com:8903/s2/logout">自己退出</a>
<a href="http://sso.com:8901/sso/logout">统一退出</a>
</body>
</html>