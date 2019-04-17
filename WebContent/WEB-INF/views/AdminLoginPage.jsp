<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body>

<h1>Home Insurance</h1>
<h2><font color = "blue">Admin Login</font></h2>
	
		
	<form action="${pageContext.request.contextPath}/admin/loginAdminUser" method="post">
		
		<div>
			<label>Admin User Name:</label>
			<input type="text" name="userName"/>
		</div>
		
		<div>
			<label>Password:</label>
			<input type="PASSWORD" name="password"/>
		</div>
		
		<div>
			<input type="submit" value="Login"/>
		</div>
		
	</form>
	
	<%@ page import="java.util.ArrayList"%>
	<span><a href="${pageContext.request.contextPath}/showLoginPage">Back to User Login</a></span>
	<span><b>New User?</b></span>
	<span><a href="${pageContext.request.contextPath}/showRegistrationPage">Register Here</a></span>
	
	
	<c:forEach items="${errorList}" var="error"> 
	    <p style="color: red;">${error}</p>
	</c:forEach>


</body>
</html>