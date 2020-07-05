<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="webMarketPackage.Product"%>
<%@page import="webMarketPackage.ProductCatalog"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Store</title>
</head>
<body>
	<h1>Student Store</h1>
	<p>Items available</p>

	<%
	ProductCatalog cat = (ProductCatalog)getServletContext().getAttribute("productCatalog");
	Map<String,Product> catalog = cat.getCatalog();
	out.print("<ul>");
	for(String id : catalog.keySet()){
		out.print("<li>");
		out.print("<a href=\"ProductServlet?id=" + catalog.get(id).getId());
		out.print("\">");
		out.print(catalog.get(id).getName());
		out.print("</a>");
		out.print("</li>");
	}
	out.print("</ul>");
	%>
	
</body>
</html>