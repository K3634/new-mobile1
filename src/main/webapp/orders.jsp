<%@page import="java.text.DecimalFormat"%>
<%@page import="com.codewithkrish.newmobile.dao.DbConnectorImplMySql"%>
<%@page import="com.codewithkrish.newmobile.model.*"%>
<%@page import="com.codewithkrish.newmobile.dao.OrderDao"%>
<%@page import="com.codewithkrish.newmobile.dao.ProductDao"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
	
	%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>TechMart</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	
	<%@include file="/includes/footer.jsp"%>
</body>
</html>
