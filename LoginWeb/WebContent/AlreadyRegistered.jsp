<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AlreadyRegistered</title>
</head>
<body>
	<h1>The Name <%request.getAttribute("username"); %>
		is already in use
	</h1>
	<p>Please enter another name and password.</p>
	<form action="AccountCreateServlet" method="post">
		User Name: <input type="text" name="username" value=""></input>
		<br>
		PassWord:  <input type="password" name="password" value="" ></input>
		<input type="submit" value="register"></input>
	</form>
	<a href="loginServlet">Back to Homepage</a>
</body>
</html>