<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="webMarketPackage.Product"%>
<%@page import="webMarketPackage.ProductCatalog"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
<%
	ProductCatalog cat = (ProductCatalog)getServletContext().getAttribute("productCatalog");
	out.print(cat.getProduct(request.getParameter("id")).getName());
%>
</title>
</head>
<body>
<form action= <%= "CartServlet?id=" + request.getParameter("id")%> method="post">
	<h1>
		<%
		out.print(cat.getProduct(request.getParameter("id")).getName());	
		%>
	</h1>
	<div class = "prod-image">
		<img src= 
			<%=
			"store-images/" + cat.getProduct(request.getParameter("id")).getImageFile()
			%>
		>
	</div>
	<div class = "price">
		 <%= "$" + cat.getProduct(request.getParameter("id")).getPrice() %> 
		 <input type = "submit" value ="Add to Cart"> 
	</div>	
	<br>
	<div class = "MainPageLink">
		<a href = "homePage.jsp">Back to Store</a>
	</div>
</form>
</body>
</html>