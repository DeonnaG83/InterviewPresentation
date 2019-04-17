<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>Home Insurance</h1>
	<h2 ><font color = "blue">User Login</font></h2>
		
	<form action="${pageContext.request.contextPath}/login" method="post">
		
		<div>
			<label>User Name:</label>
			<input type="text" name="userName"/>
		</div>
		
		<div>
			<label>Password:</label>
			<input type="PASSWORD" name="password"/>
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