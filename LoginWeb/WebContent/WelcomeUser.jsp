<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome <%= request.getAttribute("username")%></h1>
	<a href="loginServlet">Back to Homepage</a>
</body>
</html>