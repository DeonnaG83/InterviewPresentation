<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<p>	<%@ include file="header1.html" %></p>
	<p><p style="text-align:center;"><%@ include file="Navigation.html" %></p>
	
	<h2 align ="center">Welcome ${currentUser.userName}!</h2>
	
	<h2>Get Started Page</h2>
	
		
		<div>
			
			<form action =  "${pageContext.request.contextPath}/showGetQuotePage1">
			<span><b> 
			<input type="submit" style= color:white;background-color:DodgerBlue;width:150px;height:40px; value="GET QUOTE"/>
			</b></span>
			</form>
			
		</div>
		
		<div>
			<form action =  "${pageContext.request.contextPath}/retrieveQuote">
			<span><b>
			<input type="submit" style= color:white;background-color:DodgerBlue;width:150px;height:40px; value="RETRIEVE QUOTE"/>
			</b></span>
			</form>
		</div>
	
	
</body>
</html>