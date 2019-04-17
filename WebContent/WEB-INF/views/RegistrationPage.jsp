<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>
	<h1>Create Account</h1>
	<h2><font color = "blue">User Registration</font></h2>
	<h3>-User Name must be between 2 and 50 alphanumeric characters</h3>
	<h3>-Password must be between 8 and 20 alphanumeric characters</h3>
	
	<form action="${pageContext.request.contextPath}/registerUser" method="post">
		
		<div>
			<label>User Name:</label>
			<input type="text" name="userName" style=color:blue/>
		</div>
		
		<div>
			<label>Password:</label>
			<input type="text" name="password" />
		</div>
		
		<div>
			<label>Password Confirmation:</label>
			<input type="text" name="password2" />
		</div>
		
		<div>
			<label><span><b>Request Admin Privileges:</b></span></label>
			Yes<input type="radio" name="adminRole" value ="true"/>
			No<input type="radio" name="adminRole" value ="false" checked />
			
		</div>
		
		<div>
			<input type="submit" value="Register" />
		</div>
	
	</form>
	<%@ page import="java.util.ArrayList"%>
	<a href="${pageContext.request.contextPath}/showLoginPage">Cancel</a>
	
	<c:forEach items="${errorList}" var="error"> 
	    <p style="color: red;">${error}</p>
	</c:forEach>
</body>
</html>