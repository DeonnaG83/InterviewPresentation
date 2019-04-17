<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Search Page</title>
</head>
<body>
	<h1>Home Insurance</h1>
	<p style="text-align:center;"><%@ include file="Navigation2.html" %></p>
	<h2 ><font color = "black">Search User</font></h2>
		
	<form action="${pageContext.request.contextPath}/loginAdminUser" method="post">
		
		<div>
			<label>User ID:</label>
			<input type="text" name="userId"/>
		</div>
		
		<div>
			<input type="submit" value="login" name="submitBtn"/>
		</div>
		
	</form>
	
	<%@ page import="java.util.ArrayList"%>
	<span><a href="${pageContext.request.contextPath}/admin/showAdminLoginPage">Admin Login</a></span>
	<span><b>New User?</b></span>
	<span><a href="${pageContext.request.contextPath}/showRegistrationPage">Register Here</a></span>

	
	<c:forEach items="${errorList}" var="error"> 
	    <p style="color: red;">${error}</p>
	</c:forEach>

</body>
</html>