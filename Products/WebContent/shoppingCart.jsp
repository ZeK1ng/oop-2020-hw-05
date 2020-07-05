<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="webMarketPackage.Product"%>
<%@page import="webMarketPackage.ProductCatalog"%>
<%@page import="webMarketPackage.ShoppingCart"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
<h1>Shopping Cart</h1>
<form action = "CartServlet" method = "post">
	
	<%
		ShoppingCart curr_cart = (ShoppingCart)request.getAttribute("shopping-cart");
		ProductCatalog catalog = (ProductCatalog)getServletContext().getAttribute("productCatalog");
		out.print("<ul>");
		for(String id : curr_cart.getCart().keySet()){
			out.print("<li>");
			out.print("<input type=\"text\" name=\"" + id + "\" value = \"" + curr_cart.getAmount(id) + "\">");
			out.print(catalog.getProduct(id).getName() + ", $");
			out.print(catalog.getProduct(id).getPrice());
			out.print("</li>");
		}
		out.print("</ul>");
		out.print("<p> Total: $" + curr_cart.getTC());
	%>
	<input type= "submit" value = "Update Cart" >
	<br><br>
	<div class = "MainPageLink">
		<a href = "homePage.jsp">Continue Shopping</a>
	</div>
</form>
</body>
</html>